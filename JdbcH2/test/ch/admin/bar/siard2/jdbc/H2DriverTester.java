package ch.admin.bar.siard2.jdbc;

import java.sql.*;
import java.util.*;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.*;
import ch.enterag.utils.*;

public class H2DriverTester
{
  private static final File fileSOURCE_DB = new File("testfiles/conn.h2.db");
  private static final File fileSOURCE_TRACE = new File("testfiles/conn.trace.db");
  private static final File fileTMP_DB = new File("tmp/conn.h2.db");
  private static final File fileTMP_TRACE = new File("tmp/conn.trace.db");
  private static final String _sDB_URL = "jdbc:h2:tmp/conn";
  private static final String _sDB_USER = "sa";
  private static final String _sDB_PASSWORD = "sapwd";
  private static final String sDRIVER_CLASS = "ch.admin.bar.siard2.jdbc.H2Driver";
  private static final String sTEST_H2_URL = H2Driver.getUrl("test");
  private static final String sINVALID_H2_URL = "jdbc:oracle:thin:@//localhost:1521/orcl";;
  
  private Driver _driver = null;
  private Connection _conn = null;
  
  @BeforeClass
  public static void setUpClass()
  {
    try 
    { 
      FU.copy(fileSOURCE_DB, fileTMP_DB);
      FU.copy(fileSOURCE_TRACE, fileTMP_TRACE);
    }
    catch(IOException ie) { fail(EU.getExceptionMessage(ie)); }
  } /* setUpClass */
  
  @Before
  public void setUp()
  {
    File fileDb = fileTMP_DB;
    if (fileDb.exists())
      fileDb.delete();
    try { Class.forName(sDRIVER_CLASS); }
    catch(ClassNotFoundException cnfe) { fail(cnfe.getClass().getName()+": "+cnfe.getMessage()); }
    try
    {
      _driver = DriverManager.getDriver(sTEST_H2_URL);
      _conn = DriverManager.getConnection(_sDB_URL, _sDB_USER, _sDB_PASSWORD);
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* setUp */
  
  @After
  public void tearDown()
  {
    try
    {
      if ((_conn != null) && (!_conn.isClosed()))
        _conn.close();
      else
        fail("Connection cannot be closed!");
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* tearDown */

  @Test
  public void testWrapping()
  {
    assertSame("Registration of driver wrapper failed!", H2Driver.class, _driver.getClass());
    assertSame("Choice of connection wrapper failed!", H2Connection.class, _conn.getClass());
  } /* testWrapping */
  
  @Test
  public void testCompliant()
  {
    assertSame("H2 driver not JDBC compliant!", true, _driver.jdbcCompliant());
  } /* testCompliant */
  
  @Test
  public void testAcceptsURL()
  {
    try
    {
      assertSame("Valid H2 URL not accepted!", true, _driver.acceptsURL(_sDB_URL));
      assertSame("Invalid H2 URL accepted!", false, _driver.acceptsURL(sINVALID_H2_URL));
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* testAcceptsURL */
  
  @Test
  public void testVersion()
  {
    int iMajorVersion = _driver.getMajorVersion();
    int iMinorVersion = _driver.getMinorVersion();
    String sVersion = String.valueOf(iMajorVersion)+"."+String.valueOf(iMinorVersion);
    assertEquals("Wrong H2 version "+sVersion+" found!", "1.3", sVersion);
  } /* testVersion */
  
  @Test
  public void testDriverProperties()
  {
    try
    {
      DriverPropertyInfo[] apropInfo = _driver.getPropertyInfo(_sDB_URL, new Properties());
      for (DriverPropertyInfo dpi: apropInfo)
        System.out.println(dpi.name+": "+dpi.value+" ("+String.valueOf(dpi.description)+")");
      assertSame("Unexpected driver properties!", 0, apropInfo.length);
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* testDriverProperties */

} /* H2DriverTester */
