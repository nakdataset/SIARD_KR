/*======================================================================
H2Array implements a wrapped H2 Array.
Version     : $Id: $
Application : SIARD2
Description : H2Array implements a wrapped H2 Array.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 25.05.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.sql.*;
import java.util.*;
import org.h2.tools.*;
import ch.enterag.utils.jdbc.*;

/*====================================================================*/
/** H2Array implements a wrapped H2 Array.
 * @author Hartwig Thomas
 */
public class H2Array
  extends BaseArray
  implements Array
{
  String _sTypeName = null;
  Object[] _aoElements = null;
  
  /*------------------------------------------------------------------*/
  /** constructor
   * @param typeName type name of base elements.
   * @param elements array values.
   */
  private H2Array(String sTypeName, Object[] aoElements)
  {
    super(null); // org.h2.jdbc.JdbcArray should not really be wrapped ...
    _sTypeName = sTypeName;
    _aoElements = aoElements;
  } /* constructor */

  /*------------------------------------------------------------------*/
  /** factory
   * @param typeName type name of base elements.
   * @param elements array values.
   * @return new H2Array instance.
   */
  public static H2Array newInstance(String sTypeName, Object[] aoElements)
  {
    return new H2Array(sTypeName, aoElements);
  } /* getInstance */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getBaseTypeName() throws SQLException
  {
    return _sTypeName;
  } /* getBaseTypeName */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getBaseType() throws SQLException
  {
    int iType = Types.OTHER;
    if (_sTypeName.startsWith("CHAR"))
      iType = Types.CHAR;
    else if (_sTypeName.startsWith("VARCHAR"))
      iType = Types.VARCHAR;
    else if (_sTypeName.startsWith("CLOB"))
      iType = Types.CLOB;
    else if (_sTypeName.startsWith("BINARY"))
      iType = Types.BINARY;
    else if (_sTypeName.startsWith("VARBINARY"))
      iType = Types.VARBINARY;
    else if (_sTypeName.startsWith("BLOB"))
      iType = Types.BLOB;
    else if (_sTypeName.startsWith("DECIMAL"))
      iType = Types.DECIMAL;
    else if (_sTypeName.startsWith("SMALLINT"))
      iType = Types.SMALLINT;
    else if (_sTypeName.startsWith("INTEGER"))
      iType = Types.INTEGER;
    else if (_sTypeName.startsWith("BIGINT"))
      iType = Types.BIGINT;
    else if (_sTypeName.startsWith("DOUBLE"))
      iType = Types.DOUBLE;
    else if (_sTypeName.startsWith("REAL"))
      iType = Types.REAL;
    else if (_sTypeName.startsWith("BOOLEAN"))
      iType = Types.BOOLEAN;
    else if (_sTypeName.startsWith("DATE"))
      iType = Types.DATE;
    else if (_sTypeName.startsWith("TIME"))
      iType = Types.TIME;
    else if (_sTypeName.startsWith("TIMESTAMP"))
      iType = Types.TIMESTAMP;
    return iType;
  } /* getBaseType */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getArray() throws SQLException
  {
    return _aoElements;
  } /* getArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getArray(Map<String, Class<?>> map) throws SQLException
  {
    throw new SQLFeatureNotSupportedException("H2Array does not support type mapping yet!");
  } /* getArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getArray(long index, int count) throws SQLException
  {
    return Arrays.copyOfRange(_aoElements, (int)index-1, (int)index-1+count);
  } /* getArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getArray(long index, int count,
    Map<String, Class<?>> map) throws SQLException
  {
    throw new SQLFeatureNotSupportedException("H2Array does not support type mapping yet!");
  } /* getArray */

  /*------------------------------------------------------------------*/
  /** create a simple result set with the values.
   * @param array
   * @param offset
   * @return
   */
  private ResultSet getResultSet(Object[] array) throws SQLException
  {
    SimpleResultSet rs = new SimpleResultSet();
    rs.addColumn("INDEX", Types.BIGINT, 0, 0);
    rs.addColumn("VALUE", getBaseType(), 0, 0);
    for (int i = 0; i < array.length; i++) 
      rs.addRow(Long.valueOf(i + 1), array[i]);
    return rs;
  } /* getResultSet */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getResultSet() throws SQLException
  {
    return getResultSet(_aoElements);
  } /* getResultSet */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getResultSet(Map<String, Class<?>> map)
    throws SQLException
  {
      throw new SQLFeatureNotSupportedException("H2Array does not support type mapping yet!");
  } /* getResultSet */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getResultSet(long index, int count)
    throws SQLException
  {
    return getResultSet((Object[])getArray(index, count));
  } /* getResultSet */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSet getResultSet(long index, int count,
    Map<String, Class<?>> map) throws SQLException
  {
    throw new SQLFeatureNotSupportedException("H2Array does not support type mapping yet!");
  } /* getResultSet */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void free() throws SQLException
  {
    _sTypeName = null;
    _aoElements = null;
  } /* free */
  
} /* class H2Array */
