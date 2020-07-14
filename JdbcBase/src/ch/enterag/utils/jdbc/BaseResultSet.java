/*======================================================================
BaseResultSet implements a wrapped ResultSet.
Version     : $Id: $
Application : SIARD2
Description : BaseResultSet implements a wrapped ResultSet.
              See https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 13.05.2016, Hartwig Thomas
======================================================================*/
package ch.enterag.utils.jdbc;

import java.io.*;
import java.math.*;
import java.net.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.xml.datatype.*;

/*====================================================================*/
/** BaseResultSet implements a wrapped ResultSet and serves as a base
 * for derived JDBC wrappers.
 * @author Hartwig Thomas
 */
public abstract class BaseResultSet
  implements ResultSet
{
  /** wrapped result set */
  private ResultSet _rsWrapped = null;
  // enable manipulating wasNull() for Oracle LONGs!
  protected boolean _bWasNull = false;

  /*------------------------------------------------------------------*/
  /** convert an AbstractMethodError into an SQLFeatureNotSupportedEception.
   * This error indicates that the JDBC driver wrapped implements an
   * earlier version of JDBC which did not include this method.
   * @param ame
   * @throws SQLFeatureNotSupportedException
   */
  private void throwUndefinedMethod(AbstractMethodError ame)
    throws SQLFeatureNotSupportedException
  {
    throw new SQLFeatureNotSupportedException("Undefined JDBC method!", ame);
  } /* throwUndefinedMethod */
  
  /*------------------------------------------------------------------*/
  /** constructor
   * @param rsWrapped result set to be wrapped.
   */
  public BaseResultSet(ResultSet rsWrapped)
  {
    _rsWrapped = rsWrapped;
  } /* constructor BaseResultSet */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Statement getStatement() throws SQLException
  {
    return _rsWrapped.getStatement();
  } /* getStatement */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public SQLWarning getWarnings() throws SQLException
  {
    return _rsWrapped.getWarnings();
  } /* getWarnings */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void clearWarnings() throws SQLException
  {
    _rsWrapped.clearWarnings();
  } /* clearWarnings */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getCursorName() throws SQLException
  {
    return _rsWrapped.getCursorName();
  } /* getCursorName */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void close() throws SQLException
  {
    _rsWrapped.close();
  } /* close */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean isClosed() throws SQLException
  {
    return _rsWrapped.isClosed();
  } /* isClosed */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean isBeforeFirst() throws SQLException
  {
    return _rsWrapped.isBeforeFirst();
  } /* isBeforeFirst */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean isAfterLast() throws SQLException
  {
    return _rsWrapped.isAfterLast();
  } /* isAfterLast */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean isFirst() throws SQLException
  {
    return _rsWrapped.isFirst();
  } /* isFirst */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean isLast() throws SQLException
  {
    return _rsWrapped.isLast();
  } /* isLast */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void beforeFirst() throws SQLException
  {
    _rsWrapped.beforeFirst();
  } /* beforeFirst */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void afterLast() throws SQLException
  {
    _rsWrapped.afterLast();
  } /* afterLast */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getRow() throws SQLException
  {
    return _rsWrapped.getRow();
  } /* getRow */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean absolute(int row) throws SQLException
  {
    return _rsWrapped.absolute(row);
  } /* absolute */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean relative(int rows) throws SQLException
  {
    return _rsWrapped.relative(rows);
  } /* relative */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean previous() throws SQLException
  {
    return _rsWrapped.previous();
  } /* previous */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean first() throws SQLException
  {
    return _rsWrapped.first();
  } /* first */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean last() throws SQLException
  {
    return _rsWrapped.last();
  } /* last */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean next() throws SQLException
  {
    return _rsWrapped.next();
  } /* next */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public ResultSetMetaData getMetaData() throws SQLException
  {
    return _rsWrapped.getMetaData();
  } /* getMetaData */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getHoldability() throws SQLException
  {
    return _rsWrapped.getHoldability();
  } /* getHoldability */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void setFetchDirection(int direction) throws SQLException
  {
    _rsWrapped.setFetchDirection(direction);
  } /* setFetchDirection */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getFetchDirection() throws SQLException
  {
    return _rsWrapped.getFetchDirection();
  } /* getFetchDirection */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void setFetchSize(int rows) throws SQLException
  {
    _rsWrapped.setFetchSize(rows);
  } /* setFetchSize */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getFetchSize() throws SQLException
  {
    return _rsWrapped.getFetchSize();
  } /* getFetchSize */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getType() throws SQLException
  {
    return _rsWrapped.getType();
  } /* getType */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getConcurrency() throws SQLException
  {
    return _rsWrapped.getConcurrency();
  } /* getConcurrency */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int findColumn(String columnLabel) throws SQLException
  {
    return _rsWrapped.findColumn(columnLabel);
  } /* findColumn */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean wasNull() throws SQLException
  {
    return _bWasNull;
  } /* wasNull */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNull(int columnIndex) throws SQLException
  {
    _rsWrapped.updateNull(columnIndex);
  } /* updateNull */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNull(String columnLabel) throws SQLException
  {
    updateNull(findColumn(columnLabel));
  } /* updateNull */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getString(int columnIndex) throws SQLException
  {
    String s = _rsWrapped.getString(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return s;
  } /* getString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateString(int columnIndex, String x)
    throws SQLException
  {
    _rsWrapped.updateString(columnIndex, x);
  } /* updateString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getString(String columnLabel) throws SQLException
  {
    return getString(findColumn(columnLabel));
  } /* getString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateString(String columnLabel, String x)
    throws SQLException
  {
    updateString(findColumn(columnLabel), x);
  } /* updateString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getNString(int columnIndex) throws SQLException
  {
    String s = _rsWrapped.getNString(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return s;
  } /* getNString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNString(int columnIndex, String nString)
    throws SQLException
  {
    _rsWrapped.updateNString(columnIndex, nString);
  } /* updateNString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getNString(String columnLabel) throws SQLException
  {
    return getNString(findColumn(columnLabel));
  } /* getNString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNString(String columnLabel, String nString)
    throws SQLException
  {
    updateNString(findColumn(columnLabel), nString);
  } /* updateNString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean getBoolean(int columnIndex) throws SQLException
  {
    boolean b = _rsWrapped.getBoolean(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return b;
  } /* getBoolean */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBoolean(int columnIndex, boolean x)
    throws SQLException
  {
    _rsWrapped.updateBoolean(columnIndex, x);
  } /* updateBoolean */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean getBoolean(String columnLabel) throws SQLException
  {
    return getBoolean(findColumn(columnLabel));
  } /* getBoolean */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBoolean(String columnLabel, boolean x)
    throws SQLException
  {
    updateBoolean(findColumn(columnLabel), x);
  } /* updateBoolean */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public byte getByte(int columnIndex) throws SQLException
  {
    byte by = _rsWrapped.getByte(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return by;
  } /* getByte */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateByte(int columnIndex, byte x) throws SQLException
  {
    _rsWrapped.updateByte(columnIndex, x);
  } /* updateByte */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public byte getByte(String columnLabel) throws SQLException
  {
    return getByte(findColumn(columnLabel));
  } /* getByte */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateByte(String columnLabel, byte x)
    throws SQLException
  {
    updateByte(findColumn(columnLabel), x);
  } /* updateByte */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public short getShort(int columnIndex) throws SQLException
  {
    Short sh = _rsWrapped.getShort(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return sh;
  } /* getShort */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateShort(int columnIndex, short x) throws SQLException
  {
    _rsWrapped.updateShort(columnIndex, x);
  } /* updateShort */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public short getShort(String columnLabel) throws SQLException
  {
    return getShort(findColumn(columnLabel));
  } /* getShort */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateShort(String columnLabel, short x)
    throws SQLException
  {
    updateShort(findColumn(columnLabel), x);
  } /* updateShort */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getInt(int columnIndex) throws SQLException
  {
    int i = _rsWrapped.getInt(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return i;
  } /* getInt */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateInt(int columnIndex, int x) throws SQLException
  {
    _rsWrapped.updateInt(columnIndex, x);
  } /* updateInt */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public int getInt(String columnLabel) throws SQLException
  {
    return getInt(findColumn(columnLabel));
  } /* getInt */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateInt(String columnLabel, int x) throws SQLException
  {
    updateInt(findColumn(columnLabel), x);
  } /* updateInt */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public long getLong(int columnIndex) throws SQLException
  {
    long l = _rsWrapped.getLong(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return l;
  } /* getLong */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateLong(int columnIndex, long x) throws SQLException
  {
    _rsWrapped.updateLong(columnIndex, x);
  } /* updateLong */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public long getLong(String columnLabel) throws SQLException
  {
    return getLong(findColumn(columnLabel));
  } /* getLong */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateLong(String columnLabel, long x)
    throws SQLException
  {
    updateLong(findColumn(columnLabel), x);
  } /* updateLong */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public float getFloat(int columnIndex) throws SQLException
  {
    float f = _rsWrapped.getFloat(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return f;
  } /* getFloat */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateFloat(int columnIndex, float x) throws SQLException
  {
    _rsWrapped.updateFloat(columnIndex, x);
  } /* updateFloat */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public float getFloat(String columnLabel) throws SQLException
  {
    return getFloat(findColumn(columnLabel));
  } /* getFloat */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateFloat(String columnLabel, float x)
    throws SQLException
  {
    updateFloat(findColumn(columnLabel), x);
  } /* updateFloat */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public double getDouble(int columnIndex) throws SQLException
  {
    double d = _rsWrapped.getDouble(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return d;
  } /* getDouble */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateDouble(int columnIndex, double x)
    throws SQLException
  {
    _rsWrapped.updateDouble(columnIndex, x);
  } /* updateDouble */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public double getDouble(String columnLabel) throws SQLException
  {
    return getDouble(findColumn(columnLabel));
  } /* getDouble */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateDouble(String columnLabel, double x)
    throws SQLException
  {
    updateDouble(findColumn(columnLabel), x);
  } /* updateDouble */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public BigDecimal getBigDecimal(int columnIndex) throws SQLException
  {
    BigDecimal bd = _rsWrapped.getBigDecimal(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return bd;
  } /* getBigDecimal */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBigDecimal(int columnIndex, BigDecimal x)
    throws SQLException
  {
    _rsWrapped.updateBigDecimal(columnIndex, x);
  } /* updateBigDecimal */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public BigDecimal getBigDecimal(String columnLabel)
    throws SQLException
  {
    return getBigDecimal(findColumn(columnLabel));
  } /* getBigDecimal */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBigDecimal(String columnLabel, BigDecimal x)
    throws SQLException
  {
    updateBigDecimal(findColumn(columnLabel), x);
  } /* updateBigDecimal */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  @Deprecated
  public BigDecimal getBigDecimal(int columnIndex, int scale)
    throws SQLException
  {
    BigDecimal bd = _rsWrapped.getBigDecimal(columnIndex, scale);
    _bWasNull = _rsWrapped.wasNull();
    return bd;
  } /* getBigDecimal */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  @Deprecated
  public BigDecimal getBigDecimal(String columnLabel, int scale)
    throws SQLException
  {
    return getBigDecimal(findColumn(columnLabel), scale);
  } /* getBigDecimal */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public byte[] getBytes(int columnIndex) throws SQLException
  {
    byte[] buf = _rsWrapped.getBytes(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return buf;
  } /* getBytes */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBytes(int columnIndex, byte[] x)
    throws SQLException
  {
    _rsWrapped.updateBytes(columnIndex, x);
  } /* updateBytes */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public byte[] getBytes(String columnLabel) throws SQLException
  {
    return getBytes(findColumn(columnLabel));
  } /* getBytes */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBytes(String columnLabel, byte[] x)
    throws SQLException
  {
    updateBytes(findColumn(columnLabel), x);
  } /* updateBytes */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Date getDate(int columnIndex) throws SQLException
  {
    Date date = _rsWrapped.getDate(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return date;
  } /* getDate */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateDate(int columnIndex, Date x) throws SQLException
  {
    _rsWrapped.updateDate(columnIndex, x);
  } /* updateDate */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Date getDate(String columnLabel) throws SQLException
  {
    return getDate(findColumn(columnLabel));
  } /* getDate */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateDate(String columnLabel, Date x)
    throws SQLException
  {
    updateDate(findColumn(columnLabel), x);
  } /* updateDate */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Date getDate(int columnIndex, Calendar cal)
    throws SQLException
  {
    Date date = _rsWrapped.getDate(columnIndex, cal);
    _bWasNull = _rsWrapped.wasNull();
    return date;
  } /* getDate */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Date getDate(String columnLabel, Calendar cal)
    throws SQLException
  {
    return getDate(findColumn(columnLabel), cal);
  } /* getDate */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Time getTime(int columnIndex) throws SQLException
  {
    Time time = _rsWrapped.getTime(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return time;
  } /* getTime */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateTime(int columnIndex, Time x) throws SQLException
  {
    _rsWrapped.updateTime(columnIndex, x);
  } /* updateTime */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Time getTime(String columnLabel) throws SQLException
  {
    return getTime(findColumn(columnLabel));
  } /* getTime */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateTime(String columnLabel, Time x)
    throws SQLException
  {
    updateTime(findColumn(columnLabel), x);
  } /* updateTime */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Time getTime(int columnIndex, Calendar cal)
    throws SQLException
  {
    Time time = _rsWrapped.getTime(columnIndex, cal);
    _bWasNull = _rsWrapped.wasNull();
    return time;
  } /* getTime */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Time getTime(String columnLabel, Calendar cal)
    throws SQLException
  {
    return getTime(findColumn(columnLabel), cal);
  } /* getTime */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Timestamp getTimestamp(int columnIndex) throws SQLException
  {
    Timestamp ts = _rsWrapped.getTimestamp(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return ts;
  } /* getTimestamp */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateTimestamp(int columnIndex, Timestamp x)
    throws SQLException
  {
    _rsWrapped.updateTimestamp(columnIndex, x);
  } /* updateTimestamp */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Timestamp getTimestamp(String columnLabel) throws SQLException
  {
    return getTimestamp(findColumn(columnLabel));
  } /* getTimestamp */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateTimestamp(String columnLabel, Timestamp x)
    throws SQLException
  {
    updateTimestamp(findColumn(columnLabel), x);
  } /* updateTimestamp */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Timestamp getTimestamp(int columnIndex, Calendar cal)
    throws SQLException
  {
    Timestamp ts = _rsWrapped.getTimestamp(columnIndex, cal);
    _bWasNull = _rsWrapped.wasNull();
    return ts;
  } /* getTimestamp */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Timestamp getTimestamp(String columnLabel, Calendar cal)
    throws SQLException
  {
    return getTimestamp(findColumn(columnLabel), cal);
  } /* getTimestamp */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public InputStream getAsciiStream(int columnIndex)
    throws SQLException
  {
    InputStream is = _rsWrapped.getAsciiStream(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return is;
  } /* getAsciiStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateAsciiStream(int columnIndex, InputStream x)
    throws SQLException
  {
    _rsWrapped.updateAsciiStream(columnIndex, x);
  } /* updateAsciiStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public InputStream getAsciiStream(String columnLabel)
    throws SQLException
  {
    return getAsciiStream(findColumn(columnLabel));
  } /* getAsciiStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateAsciiStream(String columnLabel, InputStream x)
    throws SQLException
  {
    updateAsciiStream(findColumn(columnLabel), x);
  } /* updateAsciiStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateAsciiStream(int columnIndex, InputStream x,
    int length) throws SQLException
  {
    _rsWrapped.updateAsciiStream(columnIndex, x, length);
  } /* updateAsciiStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateAsciiStream(String columnLabel, InputStream x,
    int length) throws SQLException
  {
    updateAsciiStream(findColumn(columnLabel), x, length);
  } /* updateAsciiStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateAsciiStream(int columnIndex, InputStream x,
    long length) throws SQLException
  {
    _rsWrapped.updateAsciiStream(columnIndex, x, length);
  } /* updateAsciiStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateAsciiStream(String columnLabel, InputStream x,
    long length) throws SQLException
  {
    updateAsciiStream(findColumn(columnLabel), x, length);
  } /* updateAsciiStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  @Deprecated
  public InputStream getUnicodeStream(int columnIndex)
    throws SQLException
  {
    InputStream is = _rsWrapped.getUnicodeStream(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return is;
  } /* getUnicodeStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  @Deprecated
  public InputStream getUnicodeStream(String columnLabel)
    throws SQLException
  {
    return getUnicodeStream(findColumn(columnLabel));
  } /* getUnicodeStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Reader getCharacterStream(int columnIndex) throws SQLException
  {
    Reader rdr = _rsWrapped.getCharacterStream(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return rdr;
  } /* getCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateCharacterStream(int columnIndex, Reader x)
    throws SQLException
  {
    _rsWrapped.updateCharacterStream(columnIndex, x);
  } /* updateCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Reader getCharacterStream(String columnLabel)
    throws SQLException
  {
    return getCharacterStream(findColumn(columnLabel));
  } /* getCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateCharacterStream(String columnLabel, Reader reader)
    throws SQLException
  {
    updateCharacterStream(findColumn(columnLabel), reader);
  } /* updateCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateCharacterStream(int columnIndex, Reader x,
    int length) throws SQLException
  {
    _rsWrapped.updateCharacterStream(columnIndex, x, length);
  } /* updateCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateCharacterStream(String columnLabel, Reader reader,
    int length) throws SQLException
  {
    updateCharacterStream(findColumn(columnLabel), reader, length);
  } /* updateCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateCharacterStream(int columnIndex, Reader x,
    long length) throws SQLException
  {
    _rsWrapped.updateCharacterStream(columnIndex, x, length);
  } /* updateCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateCharacterStream(String columnLabel, Reader reader,
    long length) throws SQLException
  {
    updateCharacterStream(findColumn(columnLabel), reader, length);
  } /* updateCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Reader getNCharacterStream(int columnIndex)
    throws SQLException
  {
    Reader rdr = _rsWrapped.getNCharacterStream(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return rdr;
  } /* getNCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNCharacterStream(int columnIndex, Reader x,
    long length) throws SQLException
  {
    _rsWrapped.updateNCharacterStream(columnIndex, x, length);
  } /* updateNCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Reader getNCharacterStream(String columnLabel)
    throws SQLException
  {
    return getNCharacterStream(findColumn(columnLabel));
  } /* getNCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNCharacterStream(String columnLabel, Reader reader,
    long length) throws SQLException
  {
    updateNCharacterStream(findColumn(columnLabel), reader, length);
  } /* updateNCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNCharacterStream(int columnIndex, Reader x)
    throws SQLException
  {
    _rsWrapped.updateNCharacterStream(columnIndex, x);
  } /* updateNCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNCharacterStream(String columnLabel, Reader reader)
    throws SQLException
  {
    updateNCharacterStream(findColumn(columnLabel), reader);
  } /* updateNCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public InputStream getBinaryStream(int columnIndex)
    throws SQLException
  {
    InputStream is = _rsWrapped.getBinaryStream(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return is;
  } /* getBinaryStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBinaryStream(int columnIndex, InputStream x)
    throws SQLException
  {
    _rsWrapped.updateBinaryStream(columnIndex, x);
  } /* updateBinaryStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public InputStream getBinaryStream(String columnLabel)
    throws SQLException
  {
    return getBinaryStream(findColumn(columnLabel));
  } /* getBinaryStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBinaryStream(String columnLabel, InputStream x)
    throws SQLException
  {
    updateBinaryStream(findColumn(columnLabel), x);
  } /* updateBinaryStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBinaryStream(int columnIndex, InputStream x,
    int length) throws SQLException
  {
    _rsWrapped.updateBinaryStream(columnIndex, x, length);
  } /* updateBinaryStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBinaryStream(String columnLabel, InputStream x,
    int length) throws SQLException
  {
    updateBinaryStream(findColumn(columnLabel), x, length);
  } /* updateBinaryStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBinaryStream(int columnIndex, InputStream x,
    long length) throws SQLException
  {
    _rsWrapped.updateBinaryStream(columnIndex, x, length);
  } /* updateBinaryStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBinaryStream(String columnLabel, InputStream x,
    long length) throws SQLException
  {
    updateBinaryStream(findColumn(columnLabel), x, length);
  } /* updateBinaryStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getObject(int columnIndex) throws SQLException
  {
    Object o = _rsWrapped.getObject(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return o;
  } /* getObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateObject(int columnIndex, Object x)
    throws SQLException
  {
    _rsWrapped.updateObject(columnIndex, x);
  } /* updateObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getObject(String columnLabel) throws SQLException
  {
    return getObject(findColumn(columnLabel));
  } /* getObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateObject(String columnLabel, Object x)
    throws SQLException
  {
    updateObject(findColumn(columnLabel), x);
  } /* updateObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateObject(int columnIndex, Object x, int scaleOrLength)
    throws SQLException
  {
    _rsWrapped.updateObject(columnIndex, x, scaleOrLength);
  } /* updateObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateObject(String columnLabel, Object x,
    int scaleOrLength) throws SQLException
  {
    updateObject(findColumn(columnLabel), x, scaleOrLength);
  } /* updateObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getObject(int columnIndex, Map<String, Class<?>> map)
    throws SQLException
  {
    Object o = _rsWrapped.getObject(columnIndex, map);
    _bWasNull = _rsWrapped.wasNull();
    return o;
  } /* getObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Object getObject(String columnLabel, Map<String, Class<?>> map)
    throws SQLException
  {
    return getObject(findColumn(columnLabel), map);
  } /* getObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public <T> T getObject(int columnIndex, Class<T> type)
    throws SQLException
  {
    T o = null;
    try 
    { 
      o = _rsWrapped.getObject(columnIndex, type);
      _bWasNull = _rsWrapped.wasNull();
    }
    catch (AbstractMethodError ame) { throwUndefinedMethod(ame); }
    return o;
  } /* getObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public <T> T getObject(String columnLabel, Class<T> type)
    throws SQLException
  {
    return getObject(findColumn(columnLabel), type);
  } /* getObject */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Ref getRef(int columnIndex) throws SQLException
  {
    Ref ref = _rsWrapped.getRef(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return ref;
  } /* getRef */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateRef(int columnIndex, Ref x) throws SQLException
  {
    _rsWrapped.updateRef(columnIndex, x);
  } /* updateRef */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Ref getRef(String columnLabel) throws SQLException
  {
    return getRef(findColumn(columnLabel));
  } /* getRef */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateRef(String columnLabel, Ref x) throws SQLException
  {
    updateRef(findColumn(columnLabel), x);
  } /* updateRef */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Blob getBlob(int columnIndex) throws SQLException
  {
    Blob blob = _rsWrapped.getBlob(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return blob;
  } /* getBlob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBlob(int columnIndex, Blob x) throws SQLException
  {
    _rsWrapped.updateBlob(columnIndex, x);
  } /* updateBlob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Blob getBlob(String columnLabel) throws SQLException
  {
    return getBlob(findColumn(columnLabel));
  } /* getBlob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBlob(String columnLabel, Blob x)
    throws SQLException
  {
    updateBlob(findColumn(columnLabel), x);
  } /* updateBlob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBlob(int columnIndex, InputStream inputStream)
    throws SQLException
  {
    _rsWrapped.updateBlob(columnIndex, inputStream);
  } /* updateBlob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBlob(String columnLabel, InputStream inputStream)
    throws SQLException
  {
    updateBlob(findColumn(columnLabel), inputStream);
  } /* updateBlob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBlob(int columnIndex, InputStream inputStream,
    long length) throws SQLException
  {
    _rsWrapped.updateBlob(columnIndex, inputStream, length);
  } /* updateBlob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateBlob(String columnLabel, InputStream inputStream,
    long length) throws SQLException
  {
    updateBlob(findColumn(columnLabel), inputStream, length);
  } /* updateBlob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Clob getClob(int columnIndex) throws SQLException
  {
    Clob clob = _rsWrapped.getClob(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return clob;
  } /* getClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateClob(int columnIndex, Clob x) throws SQLException
  {
    _rsWrapped.updateClob(columnIndex, x);
  } /* updateClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Clob getClob(String columnLabel) throws SQLException
  {
    return getClob(findColumn(columnLabel));
  } /* getClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateClob(String columnLabel, Clob x)
    throws SQLException
  {
    updateClob(findColumn(columnLabel), x);
  } /* updateClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateClob(int columnIndex, Reader reader)
    throws SQLException
  {
    _rsWrapped.updateClob(columnIndex, reader);
  } /* updateClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateClob(String columnLabel, Reader reader)
    throws SQLException
  {
    updateClob(findColumn(columnLabel), reader);
  } /* updateClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateClob(int columnIndex, Reader reader, long length)
    throws SQLException
  {
    _rsWrapped.updateClob(columnIndex, reader, length);
  } /* updateClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateClob(String columnLabel, Reader reader, long length)
    throws SQLException
  {
    updateClob(findColumn(columnLabel), reader, length);
  } /* updateClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public NClob getNClob(int columnIndex) throws SQLException
  {
    NClob nclob = _rsWrapped.getNClob(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return nclob;
  } /* getNClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNClob(int columnIndex, NClob nClob)
    throws SQLException
  {
    _rsWrapped.updateNClob(columnIndex, nClob);
  } /* updateNClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public NClob getNClob(String columnLabel) throws SQLException
  {
    return getNClob(findColumn(columnLabel));
  } /* getNClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNClob(String columnLabel, NClob nClob)
    throws SQLException
  {
    updateNClob(findColumn(columnLabel), nClob);
  } /* updateNClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNClob(int columnIndex, Reader reader)
    throws SQLException
  {
    _rsWrapped.updateNClob(columnIndex, reader);
  } /* updateNClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNClob(String columnLabel, Reader reader)
    throws SQLException
  {
    updateNClob(findColumn(columnLabel), reader);
  } /* updateNClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNClob(int columnIndex, Reader reader, long length)
    throws SQLException
  {
    _rsWrapped.updateNClob(columnIndex, reader, length);
  } /* updateNClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateNClob(String columnLabel, Reader reader, long length)
    throws SQLException
  {
    updateNClob(findColumn(columnLabel), reader, length);
  } /* updateNClob */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Array getArray(int columnIndex) throws SQLException
  {
    Array array = _rsWrapped.getArray(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return array;
  } /* getArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateArray(int columnIndex, Array x) throws SQLException
  {
    _rsWrapped.updateArray(columnIndex, x);
  } /* updateArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Array getArray(String columnLabel) throws SQLException
  {
    return getArray(findColumn(columnLabel));
  } /* getArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateArray(String columnLabel, Array x)
    throws SQLException
  {
    updateArray(findColumn(columnLabel), x);
  } /* updateArray */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public RowId getRowId(int columnIndex) throws SQLException
  {
    RowId rowid = _rsWrapped.getRowId(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return rowid;
  } /* getRowId */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateRowId(int columnIndex, RowId x) throws SQLException
  {
    _rsWrapped.updateRowId(columnIndex, x);
  } /* updateRowId */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public RowId getRowId(String columnLabel) throws SQLException
  {
    return getRowId(findColumn(columnLabel));
  } /* getRowId */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateRowId(String columnLabel, RowId x)
    throws SQLException
  {
    updateRowId(findColumn(columnLabel), x);
  } /* updateRowId */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public SQLXML getSQLXML(int columnIndex) throws SQLException
  {
    SQLXML sqlxml = _rsWrapped.getSQLXML(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return sqlxml;
  } /* getSQLXML */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateSQLXML(int columnIndex, SQLXML xmlObject)
    throws SQLException
  {
    _rsWrapped.updateSQLXML(columnIndex, xmlObject);
  } /* updateSQLXML */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public SQLXML getSQLXML(String columnLabel) throws SQLException
  {
    return getSQLXML(findColumn(columnLabel));
  } /* getSQLXML */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateSQLXML(String columnLabel, SQLXML xmlObject)
    throws SQLException
  {
    updateSQLXML(findColumn(columnLabel), xmlObject);
  } /* updateSQLXML */

  /*------------------------------------------------------------------*/
  public Duration getDuration(int columnIndex) 
    throws SQLException, SQLFeatureNotSupportedException
  {
      throw new SQLFeatureNotSupportedException("getDuration() not supported!");
  } /* getDuration */

  /*------------------------------------------------------------------*/
  public Duration getDuration(String columnLabel) 
    throws SQLException, SQLFeatureNotSupportedException
  {
    return getDuration(findColumn(columnLabel));
  } /* getDuration */

  /*------------------------------------------------------------------*/
  public void updateDuration(int columnIndex, Duration x)
    throws SQLException
  {
    throw new SQLFeatureNotSupportedException("updateDuration() not supported!");
  } /* updateDuration */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  public void updateDuration(String columnLabel, Duration x)
    throws SQLException
  {
    updateDuration(findColumn(columnLabel), x);
  } /* updateDuration */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public URL getURL(int columnIndex) throws SQLException
  {
    URL url = _rsWrapped.getURL(columnIndex);
    _bWasNull = _rsWrapped.wasNull();
    return url;
  } /* getURL */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public URL getURL(String columnLabel) throws SQLException
  {
    return getURL(findColumn(columnLabel));
  } /* getURL */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void insertRow() throws SQLException
  {
    _rsWrapped.insertRow();
  } /* insertRow */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void updateRow() throws SQLException
  {
    _rsWrapped.updateRow();
  } /* updateRow */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void deleteRow() throws SQLException
  {
    _rsWrapped.deleteRow();
  } /* deleteRow */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void refreshRow() throws SQLException
  {
    _rsWrapped.refreshRow();
  } /* refreshRow */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean rowUpdated() throws SQLException
  {
    return _rsWrapped.rowUpdated();
  } /* rowUpdated */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean rowInserted() throws SQLException
  {
    return _rsWrapped.rowInserted();
  } /* rowInserted */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean rowDeleted() throws SQLException
  {
    return _rsWrapped.rowDeleted();
  } /* rowDeleted */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void cancelRowUpdates() throws SQLException
  {
    _rsWrapped.cancelRowUpdates();
  } /* cancelRowUpdates */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void moveToInsertRow() throws SQLException
  {
    _rsWrapped.moveToInsertRow();
  } /* moveToInsertRow */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void moveToCurrentRow() throws SQLException
  {
    _rsWrapped.moveToCurrentRow();
  } /* moveToCurrentRow */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException
  {
    return (iface == ResultSet.class);
  } /* isWrapperFor */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  @SuppressWarnings("unchecked")
  public <T> T unwrap(Class<T> iface) throws SQLException
  {
    T wrapped = null;
    if (isWrapperFor(iface))
      wrapped = (T)_rsWrapped;
    return wrapped;
  } /* unwrap */

} /* BaseResultSet */
