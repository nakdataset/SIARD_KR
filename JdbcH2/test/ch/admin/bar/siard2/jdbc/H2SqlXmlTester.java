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

public class H2SqlXmlTester extends BaseSqlXmlTester
{
  private static String _sSqlSimpleQuery = null;
  static
  {
    StringBuilder sbSql = new StringBuilder("SELECT\r\n  ");
    for (int iColumn = 0; iColumn < TestSqlDatabase._listCdSimple.size(); iColumn++)
    {
      if (iColumn > 0)
        sbSql.append(",\r\n  ");
      TestColumnDefinition tcd = TestSqlDatabase._listCdSimple.get(iColumn);
      sbSql.append(tcd.getName());
    }
    sbSql.append("\r\nFROM ");
    sbSql.append(TestSqlDatabase.getQualifiedSimpleTable().format());
    _sSqlSimpleQuery = sbSql.toString();
  }

  private static final File fileSOURCE_DB = new File("testfiles/conn.h2.db");
  private static final File fileSOURCE_TRACE = new File("testfiles/conn.trace.db");
  private static final File fileTMP_DB = new File("tmp/conn.h2.db");
  private static final File fileTMP_TRACE = new File("tmp/conn.trace.db");
  private static final String _sDB_URL = "jdbc:h2:tmp/conn";
  private static final String _sDB_USER = "sa";
  private static final String _sDB_PASSWORD = "sapwd";
  private SQLXML _sqlxml = null;
  private Statement _stmt = null;

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
      Connection conn = dsH2.getConnection();
      /* drop and create the test database */
      new TestSqlDatabase(conn);
      conn.close();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
    catch(IOException ie) { fail(EU.getExceptionMessage(ie)); }
  } /* setUpClass */
  
  @Before
  public void setUp()
  {
    try 
    { 
      H2DataSource dsH2 = new H2DataSource();
      dsH2.setUrl(_sDB_URL);
      dsH2.setUser(_sDB_USER);
      dsH2.setPassword(_sDB_PASSWORD);
      Connection conn = dsH2.getConnection();
      _stmt = conn.createStatement();
      ResultSet rs = _stmt.executeQuery(_sSqlSimpleQuery);
      if (rs.next())
      {
        _sqlxml = rs.getSQLXML("CXML");
        setSqlXml(_sqlxml);
      }
      rs.close();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* setUp */
  
  @After
  public void tearDown()
  {
    super.tearDown();
    try
    {
      Connection conn = null;
      if (_stmt != null)
        conn = _stmt.getConnection();
      if ((_stmt != null) && (!_stmt.isClosed()))
        _stmt.close();
      if (conn != null)
      {
        conn.commit();
        if (!conn.isClosed())
          conn.close();
      }
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* tearDown */
  
  @Test
  public void testClass()
  {
    assertEquals("Wrong SQLXML class!", H2SqlXml.class, _sqlxml.getClass());
  } /* testClass */
  
}
