package ch.admin.bar.siard2.jdbc;

import java.io.*;
import java.sql.*;
import static org.junit.Assert.*;
import org.junit.*;
import ch.enterag.utils.*;
import ch.enterag.utils.base.*;
import ch.enterag.utils.jdbc.*;
import ch.admin.bar.siard2.h2.*;
import ch.admin.bar.siard2.jdbcx.*;

public class H2ResultSetMetaDataTester
  extends BaseResultSetMetaDataTester
{
  private static String _sNativeSimpleQuery = null;
  static
  {
    StringBuilder sbSql = new StringBuilder("SELECT\r\n  ");
    for (int iColumn = 0; iColumn < TestH2Database._listCdSimple.size(); iColumn++)
    {
      if (iColumn > 0)
        sbSql.append(",\r\n  ");
      TestColumnDefinition tcd = TestH2Database._listCdSimple.get(iColumn);
      sbSql.append(tcd.getName());
    }
    sbSql.append("\r\nFROM ");
    sbSql.append(TestH2Database.getQualifiedSimpleTable().format());
    _sNativeSimpleQuery = sbSql.toString();
  }

  private static final File fileSOURCE_DB = new File("testfiles/conn.h2.db");
  private static final File fileSOURCE_TRACE = new File("testfiles/conn.trace.db");
  private static final File fileTMP_DB = new File("tmp/conn.h2.db");
  private static final File fileTMP_TRACE = new File("tmp/conn.trace.db");
  private static final String _sDB_URL = "jdbc:h2:tmp/conn";
  private static final String _sDB_USER = "sa";
  private static final String _sDB_PASSWORD = "sapwd";
  private H2ResultSetMetaData _rsmdH2 = null;

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
      H2Connection connH2 = (H2Connection)dsH2.getConnection();
      H2Statement stmtH2 = (H2Statement)connH2.createStatement();
      H2ResultSet rsH2 = (H2ResultSet)stmtH2.executeQuery(_sNativeSimpleQuery);
      _rsmdH2 = (H2ResultSetMetaData)rsH2.getMetaData();
      setResultSetMetaData(_rsmdH2, rsH2);
      
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* setUp */
  
  @Test
  public void testClass()
  {
    assertEquals("Wrong result set metadata class!", H2ResultSetMetaData.class, _rsmdH2.getClass());
  } /* testClass */
  
  @Test
  @Override
  public void testAll()
  {
    super.testAll();
  } /* testAll */
  
}
