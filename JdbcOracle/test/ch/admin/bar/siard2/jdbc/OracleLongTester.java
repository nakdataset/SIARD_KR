package ch.admin.bar.siard2.jdbc;

import java.sql.*;
import static org.junit.Assert.*;
import org.junit.*;
import ch.enterag.utils.*;
import ch.enterag.utils.base.*;
import ch.enterag.utils.jdbc.*;
import ch.admin.bar.siard2.jdbcx.*;

public class OracleLongTester 
	extends BaseDatabaseMetaDataTester 
{

	private static final ConnectionProperties _cp = new ConnectionProperties();	  
	private static final String _sDB_URL = "jdbc:oracle:thin:@"+_cp.getHost()+":"+_cp.getPort()+":"+_cp.getInstance();
	
 	private OracleDatabaseMetaData _dmdOracle = null;
	
	@Before
	public void setUp() 
	{
		try {
			OracleDataSource dsOracle = new OracleDataSource();
			dsOracle.setUrl(_sDB_URL);
			dsOracle.setUser("TESTUSER");
			dsOracle.setPassword("testpwd");
			
			OracleConnection connOracle = (OracleConnection) dsOracle.getConnection();
			connOracle.setAutoCommit(false);
			_dmdOracle = (OracleDatabaseMetaData) connOracle.getMetaData();
			setDatabaseMetaData(_dmdOracle);
		}
		catch(SQLException se) { fail(se.getClass().getName()+": " + se.getMessage()); }
	}

	private void listLengths(String sSql, String sColumnLabel)
	  throws SQLException
	{
	  /* if this is called AFTER the ResultSet has been gotten, then the 
	   * internal stream of the ResultSet is closed! */
    Connection conn = _dmdOracle.getConnection();
    PreparedStatement pstmt = _dmdOracle.getConnection().unwrap(Connection.class).prepareStatement(sSql);
    ResultSet rs = pstmt.executeQuery();
    rs = new OracleResultSet(rs,conn,pstmt);
    while (rs.next())
    {
      String s = rs.getString(sColumnLabel);
      System.out.println(String.valueOf(s.length()));
    }
    rs.close();
	}
	
  @Test
  public void testAllViews()
  {
    enter();
    try 
    {
      String sSql = "SELECT * FROM ALL_VIEWS";
      listLengths(sSql,"TEXT");
    } 
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); } 
  }

  @Test
  public void testGetViews()
  {
    enter();
    try
    {
      String sSql = "SELECT\r\n" +
        "  NULL AS TABLE_CAT,\r\n" +
        "  O.OWNER AS TABLE_SCHEM,\r\n" +
        "  O.OBJECT_NAME AS TABLE_NAME,\r\n" +
        "  CASE\r\n" +
        "  WHEN O.OBJECT_TYPE = 'TABLE' AND O.TEMPORARY = 'N' AND O.ORACLE_MAINTAINED = 'N' THEN 'TABLE'\r\n" +
        "  WHEN O.OBJECT_TYPE = 'TABLE' AND O.TEMPORARY = 'Y' AND O.ORACLE_MAINTAINED = 'N' THEN 'GLOBAL TEMPORARY'\r\n" +
        "  WHEN O.OBJECT_TYPE = 'TABLE' AND O.TEMPORARY = 'N' AND O.ORACLE_MAINTAINED = 'Y' THEN 'SYSTEM TABLE'\r\n" +
        "  WHEN O.OBJECT_TYPE = 'VIEW' AND O.TEMPORARY = 'N' AND O.ORACLE_MAINTAINED = 'N' THEN 'VIEW'\r\n" +
        "  WHEN O.OBJECT_TYPE = 'SYNONYM' AND O.TEMPORARY = 'N' AND O.ORACLE_MAINTAINED = 'N' THEN 'SYNONYM'\r\n" +
        "  ELSE NULL END AS TABLE_TYPE,\r\n" +
        "  TC.COMMENTS AS REMARKS,\r\n" +
        "  NULL AS TYPE_CAT,\r\n" +
        "  NULL AS TYPE_SCHEM,\r\n" +
        "  NULL AS TYPE_NAME,\r\n" +
        "  NULL AS SELF_REFERENCING_COL_NAME,\r\n" +
        "  NULL AS REF_GENERATION,\r\n" +
        "  V.TEXT AS QUERY_TEXT\r\n" +
        "  FROM ALL_OBJECTS O\r\n" +
        "  LEFT JOIN ALL_TABLES T\r\n" +
        "  ON (O.OWNER = T.OWNER AND\r\n" +
        "  O.OBJECT_NAME = T.TABLE_NAME AND\r\n" +
        "  O.OBJECT_TYPE = 'TABLE' AND\r\n" +
        "  T.NESTED = 'NO')\r\n" +
        "  LEFT JOIN ALL_VIEWS V\r\n" +
        "  ON (O.OWNER = V.OWNER AND\r\n" +
        "  O.OBJECT_NAME = V.VIEW_NAME AND\r\n" +
        "  O.OBJECT_TYPE = 'VIEW')\r\n" +
        "  LEFT JOIN ALL_TAB_COMMENTS TC\r\n" +
        "  ON (O.OWNER = TC.OWNER AND\r\n" +
        "  O.OBJECT_NAME = TC.TABLE_NAME AND\r\n" +
        "  O.OBJECT_TYPE = TC.TABLE_TYPE)\r\n" +
        "  WHERE\r\n" +
        "  O.OBJECT_NAME LIKE '%' ESCAPE '/'\r\n" +
        "  AND O.OWNER LIKE 'TESTSQLUSER' ESCAPE '/'\r\n" +
        "  AND (\r\n" +
        "  (O.OBJECT_TYPE = 'VIEW' AND NOT V.VIEW_NAME IS NULL)\r\n" +
        "  )\r\n" +
        "  AND O.ORACLE_MAINTAINED = 'N'\r\n" +
        "  AND O.GENERATED = 'N'\r\n" +
        "  ORDER BY TABLE_TYPE, TABLE_CAT, TABLE_SCHEM, TABLE_NAME";
      listLengths(sSql,"QUERY_TEXT");
   }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); } 
  }
  
}