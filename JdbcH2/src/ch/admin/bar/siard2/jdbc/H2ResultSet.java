/*======================================================================
H2ResultSet implements a wrapped H2 ResultSet.
Version     : $Id: $
Application : SIARD2
Description : H2ResultSet implements a wrapped H2 ResultSet.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 10.05.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.io.*;
import java.math.*;
import java.net.*;
import java.nio.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.xml.datatype.*;
import org.h2.jdbc.*;
import com.vividsolutions.jts.geom.*;
import ch.enterag.utils.jdbc.*;
import ch.enterag.utils.logging.*;
import ch.enterag.sqlparser.*;

/*====================================================================*/
/** H2ResultSet implements a wrapped H2 ResultSet.
 * @author Hartwig Thomas
 */
public class H2ResultSet
  extends BaseResultSet
  implements ResultSet
{
  /** logger */
  private static IndentLogger _il = IndentLogger.getIndentLogger(H2ResultSet.class.getName());
  protected Connection _conn = null;
  
  /*------------------------------------------------------------------*/
  /** convert an H2 JdbcSQLException into an SQLFeatureNotSupportedException.
   * @param jse
   * @throws SQLFeatureNotSupportedException
   */
  private void throwNotSupportedException(JdbcSQLException jse)
    throws SQLFeatureNotSupportedException
  {
    throw new SQLFeatureNotSupportedException("H2 Exception!", jse);
  } /* throwFeatureNotSupportedSqlException */
  
  /*------------------------------------------------------------------*/
  /** retrieve BLOB object from byte array.
   * @param buf byte array.
   * @return BLOB object.
   * @throws SQLException if an exception occurs.
   */
  private Blob getBlob(byte[] buf) throws SQLException
  {
    Blob blob = getStatement().getConnection().createBlob();
    blob.setBytes(1, buf);
    return blob;
  } /* getBlob */

  /*------------------------------------------------------------------*/
  /** map H2 object to appropriate java type.
   * @param o object.
   * @param iType its original type (from unwrapped ResultSetMetaData).
   * @return mapped object.
   * @throws SQLException if an exception occurs.
   */
  private Object mapObject(Object o, int iType) throws SQLException
  {
    if (o instanceof byte[]) // map byte[] to Blob
    {
      if (iType == Types.BLOB)
        o = getBlob((byte[])o);
    }
    else if (o instanceof UUID) // map UUID to Binary
    {
      UUID uuid = (UUID)o;
      ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
      bb.putLong(uuid.getMostSignificantBits());
      bb.putLong(uuid.getLeastSignificantBits());
      o = bb.array();
    }
    else if (o instanceof Geometry) // map Geometry to String
    {
      Geometry g = (Geometry)o;
      o = g.toText();
    }
    else if (o instanceof Object[]) // map Object[] to Array
    {
      Object[] aoElements = (Object[])o;
      String sTypeName = "BLOB";
      Class<?> clsElements = null;
      Object oElement = null;
      for (int i = 0; i < aoElements.length; i++)
      {
        if (aoElements[i] != null)
        {
          oElement = aoElements[i];
          Class<?> clsElement = oElement.getClass();
          if (clsElements == null)
            clsElements = clsElement;
          else if (!clsElements.equals(clsElement))
            clsElements = Object.class;
        }
      }
      if (clsElements.equals(Integer.class))
        sTypeName = "INTEGER";
      else if (clsElements.equals(Long.class) || 
               clsElements.equals(BigInteger.class))
        sTypeName = "BIGINT";
      else if (clsElements.equals(BigDecimal.class))
        sTypeName = "DECIMAL";
      else if (clsElements.equals(Float.class))
        sTypeName = "REAL";
      else if (clsElements.equals(Double.class))
        sTypeName = "DOUBLE PRECISION";
      else if (clsElements.equals(String.class))
      {
        int iMaxCharLiteralLength = getStatement().getConnection().getMetaData().getMaxCharLiteralLength(); 
        sTypeName = "VARCHAR("+String.valueOf(iMaxCharLiteralLength)+")";
      }
      else if (clsElements.equals(byte[].class))
      {
        int iMaxBinaryLiteralLength = getStatement().getConnection().getMetaData().getMaxBinaryLiteralLength(); 
        sTypeName = "VARBINARY("+String.valueOf(iMaxBinaryLiteralLength)+")";
      }
      else if (clsElements.equals(Date.class))
        sTypeName = "DATE";
      else if (clsElements.equals(Time.class))
        sTypeName = "TIME";
      else if (clsElements.equals(Timestamp.class))
        sTypeName = "TIMESTAMP(9)";
      else if (clsElements.equals(Interval.class))
      {
        Interval iv = (Interval)oElement;
        if ((iv.getYears() == 0) && (iv.getMonths() == 0))
          sTypeName = "INTERVAL DAY TO SECOND";
        else
          sTypeName = "INTERVAL YEAR TO MOTNH";
      }
      o = H2Array.newInstance(sTypeName, aoElements);
    }
    else if (o instanceof Blob)
    {
      Blob blob = (Blob)o;
      Interval iv = SqlLiterals.deserialize(blob.getBytes(1l, (int)blob.length()),Interval.class);
      if (iv != null)
        o = iv.toDuration();
    }
    else if (iType == Types.OTHER) // map object to Blob
    {
      o = getBlob(SqlLiterals.serializeObject(o));
    }
    return o;
  } /* mapObject */
  
  /*------------------------------------------------------------------*/
  /** map H2 object to appropriate java type.
   * @param o original object.
   * @param iType its original type (from unwrapped ResultSetMetaData).
   * @return mapped object.
   * @throws SQLException if an exception occurs.
   */
  @SuppressWarnings("unchecked")
  private <T> T mapObject(Object o, int iType, Class<T> type) throws SQLException
  {
    T oMapped = null;
    /* first map object to appropriate object */
    Object oResult = mapObject(o, iType);
    /* then convert */
    if (oResult != o)
    {
      if (oResult instanceof Blob)
      {
        Blob blob = (Blob)oResult;
        if (type == Blob.class)
          oMapped = (T)blob;
        else // BLOB can only be converted to BLOB
          throw new SQLException("BLOB cannot be converted to "+type.getName()+"!");
      }
      else if (oResult instanceof Array)
      {
        if (type == Array.class)
          oMapped = (T)oResult;
        else // ARRAY can only be converted to ARRAY
          throw new SQLException("ARRAY cannot be converted to "+type.getName()+"!");
      }
      else if (oResult instanceof String)
      {
        String s = (String)oResult;
        if (type == String.class)
          oMapped = (T)s;
        else // can only come from GEOMETRY, which cannot be converted to anything else
          throw new SQLException("String cannot be converted to "+type.getName()+"!");
      }
      else
        oMapped = type.cast(oResult);
    }
    return oMapped;
  } /* mapObject */
  
  /*------------------------------------------------------------------*/
  /** constructor
   * @param rsWrapped result set to be wrapped.
   */
  public H2ResultSet(ResultSet rsWrapped, Connection conn)
  {
    super(rsWrapped);
    _conn = conn;
  } /* constructor */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Statement getStatement() throws SQLException
  {
    return new H2Statement(super.getStatement());
  } /* getStatement */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSetMetaData getMetaData() throws SQLException
  {
    return new H2ResultSetMetaData(super.getMetaData(),this,_conn);
  } /* getMetaData */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  @Deprecated
  public InputStream getUnicodeStream(int columnIndex)
    throws SQLException
  {
    InputStream is = null;
    try { is = super.getUnicodeStream(columnIndex); }
    catch (JdbcSQLException jse) { throwNotSupportedException(jse); }
    return is;
  } /* getUnicodeStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  @Deprecated
  public InputStream getUnicodeStream(String columnLabel)
    throws SQLException
  {
    InputStream is = null;
    try { is = getUnicodeStream(findColumn(columnLabel)); }
    catch (JdbcSQLException jse) { throwNotSupportedException(jse); }
    return is;
  } /* getUnicodeStream */

  /*------------------------------------------------------------------*/
  public Duration getDuration(int columnIndex) 
    throws SQLException, SQLFeatureNotSupportedException
  {
    Blob blob = getBlob(columnIndex);
    Interval iv = SqlLiterals.deserialize(blob.getBytes(1l,(int)blob.length()), Interval.class);
    return iv.toDuration();
  } /* getDuration */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getCursorName() throws SQLException
  {
    String sCursorName = null; 
    try { sCursorName = super.getCursorName(); }
    catch(JdbcSQLException jse) { throwNotSupportedException(jse); }
    return sCursorName;
  } /* getCursorName */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void setFetchDirection(int direction) throws SQLException
  {
    try { super.setFetchDirection(direction); }
    catch(JdbcSQLException jse) { throwNotSupportedException(jse); }
  } /* setFetchDirection */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getObject(int columnIndex) throws SQLException
  {
    int iType = getMetaData().unwrap(ResultSetMetaData.class).getColumnType(columnIndex); 
    return mapObject(super.getObject(columnIndex),iType);
  } /* getObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  @SuppressWarnings("unchecked")
  public <T> T getObject(int columnIndex, Class<T> type)
    throws SQLException
  {
    Object o = null;
    T oMapped = null;
    int iType = Types.OTHER;
    try
    {
      o = super.getObject(columnIndex);
      if (type.isInstance(o))
        oMapped = (T)o;
      else
        oMapped = mapObject(o, iType, type);
    }
    catch (SQLFeatureNotSupportedException sfnse) { _il.exception(sfnse); }
    return oMapped;
  } /* getObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getObject(int columnIndex, Map<String, Class<?>> map)
    throws SQLException
  {
    Object o = null;
    try { o = super.getObject(columnIndex, map); }
    catch(JdbcSQLException jse) { throwNotSupportedException(jse); }
    return o;
  } /* getObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Array getArray(int columnIndex) throws SQLException
  {
    Array array = null;
    Object o = super.getObject(columnIndex);
    if (o != null)
      array = mapObject(o, Types.ARRAY, Array.class);
    return array;
  } /* getArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public URL getURL(int columnIndex) throws SQLException
  {
    URL url = null;
    try { url = super.getURL(columnIndex); }
    catch(JdbcSQLException jse) { throwNotSupportedException(jse); }
    return url;
  } /* getURL */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public RowId getRowId(int columnIndex) throws SQLException
  {
    RowId ri = null;
    try { ri = super.getRowId(columnIndex); }
    catch(JdbcSQLException jse) { throwNotSupportedException(jse); }
    return ri;
  } /* getRowId */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getNString(int columnIndex) throws SQLException
  {
    return getString(columnIndex);
  } /* getNString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Reader getNCharacterStream(int columnIndex)
    throws SQLException
  {
    return getCharacterStream(columnIndex);
  } /* getNCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public NClob getNClob(int columnIndex) throws SQLException
  {
    return (NClob)getClob(columnIndex);
  } /* getNClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public SQLXML getSQLXML(int columnIndex) throws SQLException
  {
    Clob clob = getClob(columnIndex);
    SQLXML sqlxml = H2SqlXml.newInstance(clob.getSubString(1l,(int)clob.length()));
    clob.free();
    return sqlxml;
  } /* getSQLXML */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNString(int columnIndex, String nString)
    throws SQLException
  {
    updateString(columnIndex, nString);
  } /* updateNString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNClob(int columnIndex, NClob nClob)
    throws SQLException
  {
    updateClob(columnIndex, (Clob)nClob);
  } /* updateNClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNClob(int columnIndex, Reader reader)
    throws SQLException
  {
    updateClob(columnIndex, reader);
  } /* updateNClob */

  /*------------------------------------------------------------------*/
  public void updateDuration(int columnIndex, Duration x)
    throws SQLException
  {
    updateObject(columnIndex,x);
  } /* updateDuration */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNCharacterStream(int columnIndex, Reader x,
    long length) throws SQLException
  {
    updateCharacterStream(columnIndex, x, length);
  } /* updateNCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNCharacterStream(int columnIndex, Reader x)
    throws SQLException
  {
    updateCharacterStream(columnIndex, x);
  } /* updateNCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateObject(int columnIndex, Object x)
    throws SQLException
  {
    if (x instanceof H2SqlXml)
    {
      SQLXML sqlxml = (H2SqlXml)x;
      super.updateObject(columnIndex, sqlxml.getString());
    }
    else if (x instanceof H2Array)
    {
      Array array = (H2Array)x;
      super.updateObject(columnIndex, SqlLiterals.serialize(array.getArray()));
    }
    else if (x instanceof Duration)
    {
      Interval iv = Interval.fromDuration((Duration)x);
      Blob blob = getStatement().getConnection().createBlob();
      blob.setBytes(1l, SqlLiterals.serialize(iv));
      updateBlob(columnIndex,blob);
    }
    else
      super.updateObject(columnIndex, x); 
  } /* updateObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateObject(int columnIndex, Object x, int scaleOrLength)
    throws SQLException
  {
    // TODO: invert above mapping!
    super.updateObject(columnIndex, x, scaleOrLength);
  } /* updateObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateRef(int columnIndex, Ref x) throws SQLException
  {
    try { super.updateRef(columnIndex, x); }
    catch(JdbcSQLException jse) { throwNotSupportedException(jse); }
  } /* updateRef */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateArray(int columnIndex, Array x)
    throws SQLException
  {
    updateObject(columnIndex, x);
  } /* updateArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateSQLXML(int columnIndex, SQLXML xmlObject)
    throws SQLException
  {
    updateObject(columnIndex,xmlObject);
  } /* updateSQLXML */

} /* H2ResultSet */
