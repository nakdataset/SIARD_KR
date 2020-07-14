package ch.admin.bar.siard2.jdbc;

import java.sql.*;

import static org.junit.Assert.*;

import org.junit.*;

import ch.enterag.utils.*;
import ch.enterag.utils.base.*;
import ch.enterag.utils.jdbc.*;
import ch.admin.bar.siard2.db2.*;
import ch.admin.bar.siard2.jdbcx.*;

public class Db2ResultSetMetaDataTester extends BaseResultSetMetaDataTester
{
  private static final ConnectionProperties _cp = new ConnectionProperties();
  private static final String _sDB_URL = Db2Driver.getUrl(_cp.getHost()+":"+_cp.getPort()+"/"+_cp.getCatalog());
  private static final String _sDB_USER = _cp.getUser();
  private static final String _sDB_PASSWORD = _cp.getPassword();
  private static final String _sDBA_USER = _cp.getDbaUser();
  private static final String _sDBA_PASSWORD = _cp.getDbaPassword();
  
  private static String _sNativeQuerySimple = null;
  private static String _sNativeQueryComplex = null;
  private static String _sSqlQuerySimple = null;
  private static String _sSqlQueryComplex = null;
  static
  {
    StringBuilder sbSql = new StringBuilder("SELECT\r\n  ");
    for (int iColumn = 0; iColumn < TestDb2Database._listCdSimple.size(); iColumn++)
    {
      if (iColumn > 0)
        sbSql.append(",\r\n  ");
      TestColumnDefinition tcd = TestDb2Database._listCdSimple.get(iColumn);
      sbSql.append(tcd.getName());
    }
    sbSql.append("\r\nFROM ");
    sbSql.append(TestDb2Database.getQualifiedSimpleTable().format());
    _sNativeQuerySimple = sbSql.toString();
    
    sbSql = new StringBuilder("SELECT\r\n  ");
    for (int iColumn = 0; iColumn < TestDb2Database._listCdComplex.size(); iColumn++)
    {
      if (iColumn > 0)
        sbSql.append(",\r\n  ");
      TestColumnDefinition tcd = TestDb2Database._listCdComplex.get(iColumn);
      sbSql.append(tcd.getName());
    }
    sbSql.append("\r\nFROM ");
    sbSql.append(TestDb2Database.getQualifiedComplexTable().format());
    _sNativeQueryComplex = sbSql.toString();
    
    sbSql = new StringBuilder("SELECT\r\n  ");
    for (int iColumn = 0; iColumn < TestSqlDatabase._listCdSimple.size(); iColumn++)
    {
      if (iColumn > 0)
        sbSql.append(",\r\n  ");
      TestColumnDefinition tcd = TestSqlDatabase._listCdSimple.get(iColumn);
      sbSql.append(tcd.getName());
    }
    sbSql.append("\r\nFROM  ");
    sbSql.append(TestSqlDatabase.getQualifiedSimpleTable().format());
    _sSqlQuerySimple = sbSql.toString();
    
    sbSql = new StringBuilder("SELECT\r\n  ");
    for (int iColumn = 0; iColumn < TestSqlDatabase._listCdComplex.size(); iColumn++)
    {
      if (iColumn > 0)
        sbSql.append(",\r\n  ");
      TestColumnDefinition tcd = TestSqlDatabase._listCdComplex.get(iColumn);
      sbSql.append(tcd.getName());
    }
    sbSql.append("\r\nFROM  ");
    sbSql.append(TestSqlDatabase.getQualifiedComplexTable().format());
    _sSqlQueryComplex = sbSql.toString();
  }
  
  @BeforeClass
  public static void setUpClass()
  {
    try 
    { 
      Db2DataSource dsDb2 = new Db2DataSource();
      dsDb2.setUrl(_sDB_URL);
      dsDb2.setUser(_sDBA_USER);
      dsDb2.setPassword(_sDBA_PASSWORD);
      Db2Connection connDb2 = (Db2Connection)dsDb2.getConnection();
      /* drop and create the test database granting access to _sDB_USER */
      new TestSqlDatabase(connDb2,_sDB_USER);
      new TestDb2Database(connDb2,_sDB_USER);
      connDb2.close();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* setUpClass */
  
  private Connection closeResultSet()
    throws SQLException
  {
    Connection conn = null;
    ResultSet rs = getResultSet();
    if (rs != null)
    {
      if (!rs.isClosed())
      {
        Statement stmt = rs.getStatement();
        rs.close();
        setResultSetMetaData(null,null);
        if (!stmt.isClosed())
        {
          conn = stmt.getConnection();
          stmt.close();
        }
      }
    }
    return conn;
  } /* closeResultSet */

  private void openResultSet(Connection conn, String sQuery)
    throws SQLException
  {
    closeResultSet();
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sQuery);
    ResultSetMetaData rsmd = rs.getMetaData();
    setResultSetMetaData(rsmd,rs);
  } /* openResultSet */
  
  
  @Before
  public void setUp()
  {
    try 
    { 
      Db2DataSource dsDb2 = new Db2DataSource();
      dsDb2.setUrl(_sDB_URL);
      dsDb2.setUser(_sDB_USER);
      dsDb2.setPassword(_sDB_PASSWORD);
      Connection conn = dsDb2.getConnection();
      conn.setAutoCommit(false);
      openResultSet(conn,_sNativeQuerySimple);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* setUp */
  
  @After
  @Override
  public void tearDown()
 {
    try
    {
      Connection conn = closeResultSet();
      if (conn != null)
      {
        if (!conn.isClosed())
        {
          conn.commit();
          conn.close();
        }
      }
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* tearDown */
  
  @Test
  public void testClass()
  {
    assertEquals("Wrong database meta data class!", Db2ResultSetMetaData.class, getResultSetMetaData().getClass());
  } /* testClass */

  @Test
  public void testNativeSimple()
  {
    try
    {
      openResultSet(getResultSet().getStatement().getConnection(),_sNativeQuerySimple);
      super.testAll();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testNativeSimple */

  @Test
  public void testNativeComplex()
  {
    try
    {
      openResultSet(getResultSet().getStatement().getConnection(),_sNativeQueryComplex);
      super.testAll();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testNativeComplex */

  @Test
  public void testSqlSimple()
  {
    try
    {
      openResultSet(getResultSet().getStatement().getConnection(),_sSqlQuerySimple);
      super.testAll();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testSqlSimple */

  @Test
  public void testSqlComplex()
  {
    try
    {
      openResultSet(getResultSet().getStatement().getConnection(),_sSqlQueryComplex);
      super.testAll();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testSqlComplex */

}
