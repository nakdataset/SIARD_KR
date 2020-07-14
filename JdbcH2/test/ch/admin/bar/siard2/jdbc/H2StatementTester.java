package ch.admin.bar.siard2.jdbc;

import java.io.*;
import java.sql.*;
import static org.junit.Assert.*;
import org.junit.*;
import ch.enterag.utils.*;
import ch.enterag.utils.base.*;
import ch.enterag.utils.jdbc.*;
import ch.enterag.sqlparser.*;
import ch.admin.bar.siard2.h2.*;
import ch.admin.bar.siard2.jdbcx.*;

public class H2StatementTester extends BaseStatementTester
{
  private static final File fileSOURCE_DB = new File("testfiles/conn.h2.db");
  private static final File fileSOURCE_TRACE = new File("testfiles/conn.trace.db");
  private static final File fileTMP_DB = new File("tmp/conn.h2.db");
  private static final File fileTMP_TRACE = new File("tmp/conn.trace.db");
  private static final String _sDB_URL = "jdbc:h2:tmp/conn";
  private static final String _sDB_USER = "sa";
  private static final String _sDB_PASSWORD = "sapwd";
  private H2Statement _stmtH2 = null;

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
      new TestSqlDatabase(connH2);
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
      _stmtH2 = (H2Statement)connH2.createStatement();
      setStatement(_stmtH2);
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* setUp */
  
  @Test
  public void testClass()
  {
    assertEquals("Wrong statement class!", H2Statement.class, _stmtH2.getClass());
  } /* testClass */

  @Test
  public void testExecuteSelectSizes()
  {
    StringBuilder sbSql = new StringBuilder("SELECT COUNT(*) AS RECORDS");
    for (int iColumn = 0; iColumn < TestSqlDatabase._listCdSimple.size(); iColumn++)
    {
      TestColumnDefinition tcd = TestSqlDatabase._listCdSimple.get(iColumn);
      if (tcd.getType().startsWith("BLOB") ||
        tcd.getType().startsWith("CLOB") ||
        tcd.getType().startsWith("NCLOB"))
      {
        sbSql.append(",\r\n  SUM(OCTET_LENGTH(");
        sbSql.append(SqlLiterals.formatId(tcd.getName()));
        sbSql.append(")) AS ");
        sbSql.append(SqlLiterals.formatId(tcd.getName()+"_SIZE"));
      }
    }
    sbSql.append("\r\nFROM ");
    sbSql.append(TestSqlDatabase.getQualifiedSimpleTable().format());
    try
    {
      ResultSet rs = _stmtH2.executeQuery(sbSql.toString());
      ResultSetMetaData rsmd = rs.getMetaData();
      while(rs.next())
      {
        for (int iColumn = 0; iColumn < rsmd.getColumnCount(); iColumn++)
        {
          String sColumnName = rsmd.getColumnLabel(iColumn+1);
          long lValue = rs.getLong(iColumn+1);
          System.out.println(sColumnName+": "+String.valueOf(lValue));
        }
      }
      rs.close();
    }
    catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
  } /* testExecuteSelectSize */

} /* class H2StatementTester */
