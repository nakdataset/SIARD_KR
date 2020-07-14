package ch.admin.bar.siard2.jdbcx;

import java.io.*;
import java.sql.*;
import javax.sql.*;
import static org.junit.Assert.*;
import org.junit.*;
import ch.enterag.utils.*;

public class H2DataSourceTester
{
  private static final File fileSOURCE_DB = new File("testfiles/conn.h2.db");
  private static final File fileSOURCE_TRACE = new File("testfiles/conn.trace.db");
  private static final File fileTMP_DB = new File("tmp/conn.h2.db");
  private static final File fileTMP_TRACE = new File("tmp/conn.trace.db");
  private static final String _sDB_URL = "jdbc:h2:tmp/conn";
  private static final String _sDB_USER = "sa";
  private static final String _sDB_PASSWORD = "sapwd";

  private H2DataSource _dsH2 = null;
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
    _dsH2 = new H2DataSource();
  } /* setUp */
  
  @After
  public void tearDown()
  {
    try
    {
      if ((_conn != null) && (!_conn.isClosed()))
        _conn.close();
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* tearDown */
  
  @Test
  public void testWrapper()
  {
    try
    {
      Assert.assertSame("Invalid wrapper!", true, _dsH2.isWrapperFor(DataSource.class));
      DataSource dsWrapped = _dsH2.unwrap(DataSource.class);
      assertSame("Invalid wrapped class!", org.h2.jdbcx.JdbcDataSource.class, dsWrapped.getClass());
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* testWrapper */
  
  @Test
  public void testLoginTimeout()
  {
    try
    {
      int iLoginTimeout = _dsH2.getLoginTimeout();
      assertSame("Unexpected login timeout "+String.valueOf(iLoginTimeout)+"!", 0, iLoginTimeout);
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* testLoginTimeout */
  
  @Test
  public void testConnection()
  {
    _dsH2.setUrl(_sDB_URL);
    _dsH2.setUser(_sDB_USER);
    _dsH2.setPassword(_sDB_PASSWORD);
    try { _conn = _dsH2.getConnection(); }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* testConnection */
  
} /* H2DataSource */
