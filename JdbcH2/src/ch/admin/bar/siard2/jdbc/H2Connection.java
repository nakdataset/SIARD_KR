/*======================================================================
H2Connection implements a wrapped H2 Connection.
Version     : $Id: $
Application : SIARD2
Description : H2Connection implements a wrapped H2 Connection.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 09.03.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.sql.*;

import org.h2.jdbc.*;
import ch.enterag.utils.jdbc.*;
import ch.enterag.utils.logging.*;
import ch.enterag.sqlparser.*;
import ch.admin.bar.siard2.h2.*;

/*====================================================================*/
/** H2Connection implements a wrapped H2 Connection.
 * @author Hartwig Thomas
 */
public class H2Connection
  extends BaseConnection
  implements Connection
{
  /** logger */
  private static IndentLogger _il = IndentLogger.getIndentLogger(H2Connection.class.getName());

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
  /** constructor
   * @param connWrapped connection to be wrapped.
   */
  public H2Connection(Connection connWrapped)
  {
    super(connWrapped);
  } /* constructor */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String nativeSQL(String sql) 
    throws SQLException
  {
    _il.enter(sql);
    SqlFactory sf = new H2SqlFactory();
    SqlStatement ss = sf.newSqlStatement();
    ss.parse(sql);
    sql = ss.format();
    _il.exit(sql);
    return sql;
  } /* nativeSQL */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * wraps database meta data.
   */
  @Override
  public DatabaseMetaData getMetaData()
    throws SQLException
  {
    return new H2DatabaseMetaData(super.getMetaData());
  } /* getMetadata */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * wraps statement.
   */
  @Override
  public Statement createStatement()
      throws SQLException
  {
    return new H2Statement(super.createStatement());
  } /* createStatement */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc} 
   * wraps statement.
   */
  @Override
  public Statement createStatement(int resultSetType, int resultSetConcurrency) 
    throws SQLException
  {
    return new H2Statement(super.createStatement(resultSetType, resultSetConcurrency));
  } /* createStatement */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} 
   * wraps statement.
   */
  @Override
  public Statement createStatement(int resultSetType,
    int resultSetConcurrency, int resultSetHoldability)
    throws SQLException
  {
    return new H2Statement(super.createStatement(resultSetType, 
      resultSetConcurrency, resultSetHoldability));
  } /* createStatement */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public PreparedStatement prepareStatement(String sql)
    throws SQLException
  {
    PreparedStatement ps = super.prepareStatement(nativeSQL(sql));
    return ps;
  } /* prepareStatement */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public CallableStatement prepareCall(String sql) 
    throws SQLException
  {
    CallableStatement cs = super.prepareCall(nativeSQL(sql));
    return cs;
  } /* prepareCall */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public PreparedStatement prepareStatement(String sql,
    int resultSetType, int resultSetConcurrency)
    throws SQLException
  {
    PreparedStatement ps = super.prepareStatement(nativeSQL(sql), resultSetType, resultSetConcurrency);
    return ps;
  } /* prepareStatement */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public CallableStatement prepareCall(String sql, 
    int resultSetType, int resultSetConcurrency)
    throws SQLException
  {
    CallableStatement cs = super.prepareCall(nativeSQL(sql), resultSetType, resultSetConcurrency);
    return cs;
  } /* prepareCall */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public PreparedStatement prepareStatement(String sql,
    int resultSetType, int resultSetConcurrency,
    int resultSetHoldability)
    throws SQLException
  {
    PreparedStatement ps = super.prepareStatement(nativeSQL(sql), resultSetType, 
      resultSetConcurrency, resultSetHoldability);
    return ps;
  } /* prepareStatement */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public CallableStatement prepareCall(String sql, int resultSetType,
    int resultSetConcurrency, int resultSetHoldability)
    throws SQLException
  {
    CallableStatement cs = super.prepareCall(nativeSQL(sql), resultSetType, 
      resultSetConcurrency, resultSetHoldability); 
    return cs;
  } /* prepareCall */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
    throws SQLException
  {
    PreparedStatement ps = super.prepareStatement(nativeSQL(sql), autoGeneratedKeys);
    return ps;
  } /* prepareStatement */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
    throws SQLException
  {
    PreparedStatement ps = super.prepareStatement(nativeSQL(sql), columnIndexes);
    return ps;
  } /* prepareStatement */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public PreparedStatement prepareStatement(String sql, String[] columnNames)
    throws SQLException
  {
    PreparedStatement ps = super.prepareStatement(nativeSQL(sql), columnNames);
    return ps;
  } /* prepareStatement */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * return H2SqlXml. 
   */
  @Override
  public SQLXML createSQLXML()
      throws SQLException
  {
    SQLXML sqlxml = H2SqlXml.newInstance(null);
    return sqlxml;
  } /* createSQLXML */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc} 
   * return H2Array.
   */
  @Override
  public Array createArrayOf(String typeName, Object[] elements)
    throws SQLException
  {
    throw new SQLFeatureNotSupportedException("H2 cannot update arrays!");
    /***
    Array array = H2Array.newInstance(typeName, elements);
    return array;
    ***/
  } /* createArrayOf */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc} 
   * Convert JdbcSQLException from H2 into SQLFeatureNotSupportedError.
   */
  @Override
  public Struct createStruct(String typeName, Object[] attributes)
    throws SQLException
  {
    Struct struct = null;
    try { struct = super.createStruct(typeName, attributes); }
    catch(JdbcSQLException jse) { throwNotSupportedException(jse); }
    return struct;
  } /* createStruct */
  
} /* class H2Connection */
