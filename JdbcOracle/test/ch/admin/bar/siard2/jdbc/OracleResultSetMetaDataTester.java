package ch.admin.bar.siard2.jdbc;

import java.sql.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;
import ch.enterag.utils.*;
import ch.enterag.utils.base.*;
import ch.enterag.utils.jdbc.*;
import ch.enterag.sqlparser.identifier.*;
import ch.admin.bar.siard2.jdbcx.*;
import ch.admin.bar.siard2.oracle.*;

public class OracleResultSetMetaDataTester
	extends BaseResultSetMetaDataTester
{
	private static final ConnectionProperties _cp = new ConnectionProperties();	  
	private static final String _sDB_URL = OracleDriver.getUrl(_cp.getHost()+":"+_cp.getPort()+":"+_cp.getInstance());
  private static final String _sDBA_USER = _cp.getDbaUser();
  private static final String _sDBA_PASSWORD = _cp.getDbaPassword();
	private static final String _sDB_USER = _cp.getUser();
	private static final String _sDB_PASSWORD = _cp.getPassword();
	  
  private static String getTableQuery(QualifiedId qiTable, List<TestColumnDefinition> listCd)
  {
    StringBuilder sbSql = new StringBuilder("SELECT\r\n  ");
    for (int iColumn = 0; iColumn < listCd.size(); iColumn++)
    {
      if (iColumn > 0)
        sbSql.append(",\r\n  ");
      TestColumnDefinition tcd = listCd.get(iColumn);
      sbSql.append(tcd.getName());
    }
    sbSql.append("\r\nFROM ");
    sbSql.append(qiTable.format());
    return sbSql.toString();
  } /* getTableQuery */
  
  private static String _sNativeQuerySimple = getTableQuery(TestOracleDatabase.getQualifiedSimpleTable(),TestOracleDatabase._listCdSimple);
  private static String _sNativeQueryComplex = getTableQuery(TestOracleDatabase.getQualifiedComplexTable(),TestOracleDatabase._listCdComplex);
  private static String _sSqlQuerySimple = getTableQuery(TestSqlDatabase.getQualifiedSimpleTable(),TestSqlDatabase._listCdSimple);
  private static String _sSqlQueryComplex = getTableQuery(TestSqlDatabase.getQualifiedComplexTable(),TestSqlDatabase._listCdComplex);
 	
	@BeforeClass
	public static void setUpClass() 
	{
		try 
		{
	    OracleDataSource dsOracle = new OracleDataSource();
	    dsOracle.setUrl(_sDB_URL);
	    dsOracle.setUser( _sDBA_USER );
	    dsOracle.setPassword(_sDBA_PASSWORD);
			OracleConnection connOracle = (OracleConnection) dsOracle.getConnection();
      /** drop and create the test user
      try { TestOracleDatabase.dropUser(connOracle, _sDB_USER); }
      catch(SQLException se) {}
      TestOracleDatabase.createUser(connOracle, _sDB_USER, _sDB_PASSWORD);
      **/
      // drop and create test databases
      new TestSqlDatabase(connOracle);
      TestOracleDatabase.grantSchema(connOracle, TestSqlDatabase._sTEST_SCHEMA, _sDB_USER);
      new TestOracleDatabase(connOracle);
      TestOracleDatabase.grantSchema(connOracle, TestOracleDatabase._sTEST_SCHEMA, _sDB_USER);
			connOracle.close();
		}
		catch(SQLException se) { fail(se.getClass().getName()+": " + se.getMessage()); }
	}
	
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
	    OracleDataSource dsOracle = new OracleDataSource();
			dsOracle.setUrl(_sDB_URL);
			dsOracle.setUser(_sDB_USER);
			dsOracle.setPassword(_sDB_PASSWORD);
			Connection conn = dsOracle.getConnection();
			conn.setAutoCommit(false);
      openResultSet(conn,_sNativeQuerySimple);
		}
		catch(SQLException se) { fail(se.getClass().getName()+": " + se.getMessage()); }
	}

	@Test
	public void testClass()
	{
		assertEquals("Wrong result set metadata class!", OracleResultSetMetaData.class, getResultSetMetaData().getClass());
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

} /* OracleResultSetMetaDataTester */
