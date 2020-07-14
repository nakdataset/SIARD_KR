/*======================================================================
H2Driver implements a wrapped H2 Driver.
Version     : $Id: $
Application : SIARD2
Description : H2Driver implements a wrapped H2 Driver.
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 08.03.2016, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.jdbc;

import java.sql.*;
import java.util.*;
import ch.enterag.utils.jdbc.*;
import ch.enterag.utils.logging.*;

/*====================================================================*/
/** H2Driver implements a wrapped H2 Driver.
 * @author Hartwig Thomas
 */
public class H2Driver
  extends BaseDriver
  implements Driver
{
  /** logger */
  private static IndentLogger _il = IndentLogger.getIndentLogger(H2Driver.class.getName());
  /** protocol sub scheme for H2 JDBC URL */
  public static final String sH2_SCHEME = "h2";
  /** URL prefix for H2 JDBC URL */
  public static final String sH2_URL_PREFIX = sJDBC_SCHEME+":"+sH2_SCHEME+":";
  /** URL for database name.
   * @param sDatabaseName path/dbname (without extension .h2.db), 
   *   e.g. data/test for file data\test.h2.db 
   * @return JDBC URL.
   */
  public static String getUrl(String sDatabaseName)
  {
    String sUrl = sDatabaseName;
    if (!sUrl.startsWith(sH2_URL_PREFIX))
      sUrl = sH2_URL_PREFIX+sDatabaseName;
    return sUrl;
  } /* getUrl */

  /** register this driver, replacing original H2 driver
   */
  public static void register()
  {
    try { BaseDriver.register(new H2Driver(), "org.h2.Driver", "jdbc:h2:~/test"); }
    catch(Exception e) { throw new Error(e); }
  }

  /** replace H2 driver by this, when this class is loaded */
  static
  {
    register();
  }

  /*------------------------------------------------------------------*/
  /** {@inheritDoc}*/
  @Override
  public boolean acceptsURL(String url) throws SQLException
  {
    _il.enter(url);
    boolean bAccepts = url.startsWith("jdbc:h2:");
    _il.exit(bAccepts);
    return bAccepts;
  } /* acceptsUrl */
  
  /*------------------------------------------------------------------*/
  /** {@inheritDoc}
   * returns the appropriately wrapped H2 Connection.
   */
  @Override
  public Connection connect(String url, Properties info)
      throws SQLException
  {
    _il.enter(url, info);
    Connection conn = super.connect(url, info);
    if (conn != null)
      conn = new H2Connection(conn); 
    _il.exit(conn);
    return conn;
  } /* connect */
  
} /* class H2Driver */
