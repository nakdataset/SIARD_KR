/*======================================================================
H2DataSource implements a wrapped H2 DataSource.
Version     : $Id: $
Application : SIARD2
Description : H2DataSource implements a wrapped H2 DataSource.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 08.03.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.jdbcx;

import java.sql.*;

import javax.sql.*;
import org.h2.jdbcx.*;
import ch.admin.bar.siard2.jdbc.*;
import ch.enterag.utils.jdbcx.*;
import ch.enterag.utils.logging.*;

/*====================================================================*/
/** H2DataSource implements a wrapped H2 DataSource.
 * @author Hartwig Thomas
 */
public class H2DataSource
  extends BaseDataSource
  implements DataSource
{
  /** logger */
  private static IndentLogger _il = IndentLogger.getIndentLogger(H2DataSource.class.getName());

  /*------------------------------------------------------------------*/
  /** constructor */
  public H2DataSource()
  {
    super(new JdbcDataSource()); 
  } /* constructor H2DataSource */
  
  /*------------------------------------------------------------------*/
  /** constructor
   * @param sUrl JDBC URL identifying the database instance to connect to.
   * @param sUser database user.
   * @param sPassword password of database user.
   * @throws SQLException if a database error occurred.
   */
  public H2DataSource(String sUrl, String sUser, String sPassword)
    throws SQLException
  {
    super(new JdbcDataSource()); 
    setUrl(sUrl);
    setUser(sUser);
    setPassword(sPassword);
  } /* constructor */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * returns the appropriately wrapped H2 Connection.
   */
  @Override
  public Connection getConnection() throws SQLException
  {
    return new H2Connection(super.getConnection());
  } /* getConnection */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * returns the appropriately wrapped H2 Connection.
   */
  @Override
  public Connection getConnection(String username, String password)
      throws SQLException
  {
    return new H2Connection(super.getConnection(username, password));
  } /* getConnection */

  /*------------------------------------------------------------------*/
  /** @return unwrapped H2 DataSource
   */
  private JdbcDataSource getUnwrapped()
  {
    JdbcDataSource jds = null;
    try { jds = (JdbcDataSource)unwrap(DataSource.class); }
    catch(SQLException se) { _il.exception(se); }
    return jds;
  } /* getUnwrapped */

  /*------------------------------------------------------------------*/
  /** set URL to be used for connection.
   * @param url URL (format: "jdbc:h2:<database path>" results in file 
   *                 <database path>.h2.db)
   */
  public void setUrl(String url)
  {
    getUnwrapped().setUrl(url);
  } /* setUrl */
  
  /*------------------------------------------------------------------*/
  /** @return URL used for connection.
   */
  public String getUrl()
  {
    return getUnwrapped().getUrl();
  } /* getUrl */
  
  /*------------------------------------------------------------------*/
  /** set database user to be used for connection.
   * @param user database user to be used for connection.
   */
  public void setUser(String user)
  {
    getUnwrapped().setUser(user);
  } /* setUser */
  
  /*------------------------------------------------------------------*/
  /** @return database user used for connection.
   */
  public String getUser()
  {
    return getUnwrapped().getUser();
  } /* getUser */
  
  /*------------------------------------------------------------------*/
  /** set database password to be used for connection.
   * @param user database password to be used for connection.
   */
  public void setPassword(String password)
  {
    getUnwrapped().setPassword(password);
  } /* setPassword */
  
  /*------------------------------------------------------------------*/
  /** @return database password for connection.
   */
  public String getPassword()
  {
    return getUnwrapped().getPassword();
  } /* getPassword */
  
  /*------------------------------------------------------------------*/
  /** set database description.
   * @param description database description.
   */
  public void setDescription(String description)
  {
    getUnwrapped().setDescription(description);
  } /* setDescription */
  
  /*------------------------------------------------------------------*/
  /** @return database description.
   */
  public String getDescription()
  {
    return getUnwrapped().getDescription();
  } /* getDescription */
  
} /* class H2DataSource */
