/**
 * 
 */
package ch.admin.bar.siard2.jdbc;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.enterag.utils.base.ConnectionProperties;

/**
 * @author jutzs
 *
 */
public class OracleDriverTester {
	private static final ConnectionProperties _cp = new ConnectionProperties();	  
	private static final String _sDB_URL = OracleDriver.getUrl(_cp.getHost()+":"+_cp.getPort()+":"+_cp.getInstance());
	private static final String _sDB_USER = _cp.getUser();
	private static final String _sDB_PASSWORD = _cp.getPassword();
	
 	private static final String sDRIVER_CLASS = "ch.admin.bar.siard2.jdbc.OracleDriver";
  // private static final String sTEST_ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:orcl";;
  private static final String sTEST_ORACLE_URL = "jdbc:oracle:thin:@localhost:1521/orcl.enterag.ch";;
 	private static final String sINVALID_ORACLE_URL = "jdbc:sqlserver://localhost";
 	
 	private Driver _driver = null;
 	private Connection _conn = null;
 	
	@Before
	public void setUp() {
		try 
		{
			Class.forName(sDRIVER_CLASS); 
			_driver = DriverManager.getDriver(sTEST_ORACLE_URL);
			_conn = DriverManager.getConnection(_sDB_URL, _sDB_USER, _sDB_PASSWORD);
		} catch(ClassNotFoundException cnfe) { fail(cnfe.getClass().getName()+": " + cnfe.getMessage());
		} catch(SQLException se) { fail(se.getClass().getName()+": " + se.getMessage()); }
	} /* setUp */

	@After
	public void tearDown() {
		try
		{
			if ((_conn != null) && (!_conn.isClosed())) {
				_conn.close();
			} else {
				fail("Connection cannot be closed!");
			}
		} catch(SQLException se) { fail(se.getClass().getName()+": " + se.getMessage()); }
	} /* tearDown */

	  @Test
	public void testWrapping()
	{
		  assertSame("Registration of driver wrapper failed!", OracleDriver.class, _driver.getClass());
		  assertSame("Choice of connection wrapper failed!", OracleConnection.class, _conn.getClass());
	} /* testWrapping */
	  
	@Test
	public void testCompliant()
	{
		assertSame("Oracle driver not JDBC compliant!", true, _driver.jdbcCompliant());
	} /* testCompliant */

	@Test
	public void testAcceptsURL()
	{
		try
	    {
			assertSame("Valid Oracle URL not accepted!", true, _driver.acceptsURL(_sDB_URL));
			assertSame("Invalid Oracle URL accepted!", false, _driver.acceptsURL(sINVALID_ORACLE_URL));
	    }
		catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
	} /* testAcceptsURL */

	@Test
	public void testVersion()
	{
		int iMajorVersion = _driver.getMajorVersion();
		int iMinorVersion = _driver.getMinorVersion();
		String sVersion = String.valueOf(iMajorVersion)+"."+String.valueOf(iMinorVersion);
		assertEquals("Wrong Oracle version "+sVersion+" found!", "12.1", sVersion);
	} /* testVersion */
	  
	@Test
	public void testDriverProperties()
	{
		try
		{
			DriverPropertyInfo[] apropInfo = _driver.getPropertyInfo(_sDB_URL, new Properties());
			assertSame("Unexpected driver properties!", 99, apropInfo.length);
		}
		catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
	} /* testDriverProperties */
}
