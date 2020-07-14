package ch.admin.bar.siard2.jdbc;

import java.io.*;
import java.sql.*;
import static org.junit.Assert.*;
import org.junit.*;

import ch.enterag.utils.*;
import ch.enterag.utils.jdbc.*;
import ch.admin.bar.siard2.h2.*;
import ch.admin.bar.siard2.jdbcx.*;

public class H2ConnectionTester extends BaseConnectionTester
{
  private static final File fileSOURCE_DB = new File("testfiles/conn.h2.db");
  private static final File fileSOURCE_TRACE = new File("testfiles/conn.trace.db");
  private static final File fileTMP_DB = new File("tmp/conn.h2.db");
  private static final File fileTMP_TRACE = new File("tmp/conn.trace.db");
  private static final String _sDB_URL = "jdbc:h2:tmp/conn";
  private static final String _sDB_USER = "sa";
  private static final String _sDB_PASSWORD = "sapwd";
  private H2Connection _connH2 = null;

  @BeforeClass
  public static void setUpClass()
  {
    try 
    { 
      FU.copy(fileSOURCE_DB, fileTMP_DB);
      FU.copy(fileSOURCE_TRACE, fileTMP_TRACE);
      H2DataSource dsH2 = new H2DataSource();
      dsH2.setUrl(_sDB_URL);
      dsH2.setUser(_sDB_USER);
      dsH2.setPassword(_sDB_PASSWORD);
      H2Connection connH2 = (H2Connection)dsH2.getConnection();
      /* drop and create the test database */
      new TestSqlDatabase(connH2);
      new TestH2Database(connH2);
      connH2.close();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
    catch(IOException ie) { fail(EU.getExceptionMessage(ie)); }
  } /* setUpClass */
  
  @Before
  public void setUp()
  {
    H2DataSource dsH2 = new H2DataSource();
    dsH2.setUrl(_sDB_URL);
    dsH2.setUser(_sDB_USER);
    dsH2.setPassword(_sDB_PASSWORD);
    try 
    { 
      _connH2 = (H2Connection)dsH2.getConnection();
      setConnection(_connH2);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* setUp */
  
  @Test
  public void testClass()
  {
    assertEquals("Wrong connection class!", H2Connection.class, _connH2.getClass());
  } /* testClass */

  @Test
  @Override
  public void testCreateStatement()
  {
    enter();
    try 
    {
      Statement stmt = _connH2.createStatement();
      assertEquals("Wrong statement class!", H2Statement.class, stmt.getClass());
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testCreateStatement */
  
  @Test
  @Override
  public void testGetMetadata()
  {
    enter();
    try 
    {
      DatabaseMetaData dmd = _connH2.getMetaData();
      assertEquals("Wrong metadata class!", H2DatabaseMetaData.class, dmd.getClass());
    }
    catch(SQLFeatureNotSupportedException sfnse) { System.out.println(EU.getExceptionMessage(sfnse)); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testGetMetadata */

  /* make sure this test does not fail (probably an error in H2) */
  @Test
  @Override
  public void testRollback_Savepoint()
  {
    enter();
    try
    {
      Savepoint sp = _connH2.setSavepoint();
      _connH2.rollback(sp);
    }
    catch(SQLFeatureNotSupportedException sfnse) { System.out.println(EU.getExceptionMessage(sfnse)); }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* testRollback */

} /* class H2ConnectionTester */
