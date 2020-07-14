package ch.admin.bar.siard2.jdbc;

import java.math.*;
import java.sql.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;
import ch.enterag.utils.*;
import ch.enterag.utils.base.*;
import ch.enterag.utils.database.*;
import ch.admin.bar.siard2.jdbcx.*;

public class OracleDatabaseMetaDataBugTester 
{
	private static final ConnectionProperties _cp = new ConnectionProperties();	  
	private static final String _sDB_URL = OracleDriver.getUrl(_cp.getHost()+":"+_cp.getPort()+":"+_cp.getInstance());
  private static final String _sDB_USER = "BUGUSER";
  private static final String _sDB_PASSWORD = "bugpwd";
  private static final String _sTABLE_BUG = "BUGSIMONE";
	
  /*------------------------------------------------------------------*/
 	private OracleConnection _connOracle = null;
	
 	private static void executeDrop(Connection connNative, String sSql)
 	{
 	  try
 	  {
 	    Statement stmtNative = connNative.createStatement();
 	    int iResult = stmtNative.executeUpdate(sSql);
 	    System.out.println("Drop result: "+String.valueOf(iResult));
 	    stmtNative.close();
 	    connNative.commit();
 	  }
 	  catch(SQLException se) { System.out.println(EU.getExceptionMessage(se)); }
 	}
 	
  /*------------------------------------------------------------------*/
  private static int executeCreate(Connection connNative, String sSql)
    throws SQLException
  {
    Statement stmtNative = connNative.createStatement();
    int iResult = stmtNative.executeUpdate(sSql);
    stmtNative.close();
    connNative.commit();
    return iResult;
  } /* executeCreate */

  /*------------------------------------------------------------------*/
 	private static void dropTable(Connection connNative)
 	{
 	  executeDrop(connNative, "DELETE FROM "+_sTABLE_BUG);
 	  executeDrop(connNative, "DROP TABLE "+_sTABLE_BUG+" CASCADE CONSTRAINTS");
 	}
 	
  /*------------------------------------------------------------------*/
 	private static void createTable(Connection connNative)
 	  throws SQLException
 	{
 	  String sSql = "CREATE TABLE "+_sTABLE_BUG+
        "(ID INTEGER, VAL NUMBER, VAL1 NUMBER(5), VAL2 NUMBER(*,0), VAL3 NUMBER(10,5))";
 	  int iResult = executeCreate(connNative,sSql);
    if (iResult != 0)
      throw new SQLException(sSql + " failed!");
    sSql = "INSERT INTO "+_sTABLE_BUG+
        "(ID, VAL, VAL1, VAL2, VAL3) VALUES "+
        "(1, 3.14159, 3.14159, 3.14159, 3.14159)";
 	  iResult = executeCreate(connNative,sSql);
    if (iResult != 1)
      throw new SQLException(sSql + " failed!");
 	}
 	
  /*------------------------------------------------------------------*/
  @BeforeClass
	public static void setUpClass() 
	{
		try
		{
	    OracleDataSource dsOracle = new OracleDataSource();
	    dsOracle.setUrl(_sDB_URL);
	    dsOracle.setUser( _sDB_USER );
	    dsOracle.setPassword(_sDB_PASSWORD);
			OracleConnection connOracle = (OracleConnection) dsOracle.getConnection();
			connOracle.setAutoCommit(false);
			// drop and create bug table
		  dropTable(connOracle.unwrap(Connection.class));
		  createTable(connOracle.unwrap(Connection.class));
      connOracle.commit();
			connOracle.close();
		}
		catch(SQLException se) { fail(se.getClass().getName()+": " + se.getMessage()); }
	}
	
  public static void print(ResultSet rs)
      throws SQLException
    {
      if ((rs != null) && (!rs.isClosed()))
      {
        ResultSetMetaData rsmd = rs.getMetaData();
        if (rsmd != null)
        {
          int iColumns = rsmd.getColumnCount();
          List<String> listColumns = new ArrayList<String>();
          StringBuilder sbLine = new StringBuilder();
          for (int iColumn = 0; iColumn < iColumns; iColumn++)
          {
            if (iColumn > 0)
              sbLine.append("\t");
            String sColumnName = rsmd.getColumnLabel(iColumn+1);
            sbLine.append(sColumnName);
            listColumns.add(sColumnName);
          }
          System.out.println(sbLine.toString());
          sbLine.setLength(0);
          while (rs.next())
          {
            for (int iColumn = 0; iColumn < iColumns; iColumn++)
            {
              if (iColumn > 0)
                sbLine.append("\t");
              String sColumnName = listColumns.get(iColumn);
              String sValue = String.valueOf(rs.getObject(iColumn+1));
              if (!rs.wasNull())
              {
                if (sColumnName.equals("DATA_TYPE"))
                  sValue = sValue + " ("+SqlTypes.getTypeName(Integer.parseInt(sValue))+")";
              }
              else
                sValue = "(null)";
              sbLine.append(sValue);
            }
            System.out.println(sbLine.toString());
            sbLine.setLength(0);
          }
          rs.close();
        }
      }
      else if (rs.isClosed()) 
        throw new SQLException("Empty meta data result set!");
      else
        fail("Invalid meta data result set");
    } /* print */
    
	@Before
	public void setUp() 
	{
		try {
			OracleDataSource dsOracle = new OracleDataSource();
			dsOracle.setUrl(_sDB_URL);
			dsOracle.setUser(_sDB_USER);
			dsOracle.setPassword(_sDB_PASSWORD);
			_connOracle = (OracleConnection) dsOracle.getConnection();
			_connOracle.setAutoCommit(false);
		}
		catch(SQLException se) { fail(se.getClass().getName()+": " + se.getMessage()); }
	}

  @Test
  public void testGetColumns()
  {
    System.out.println("testGetColumns");
    try { print(_connOracle.getMetaData().getColumns(null,_sDB_USER,_sTABLE_BUG,"%")); } 
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  }
  
  @Test
  public void testGetData()
  {
    System.out.println("testGetData");
    try
    {
      String sSql = "SELECT ID, VAL, VAL1, VAL2, VAL3 FROM "+_sTABLE_BUG;
      Statement stmt = _connOracle.createStatement();
      ResultSet rs = stmt.executeQuery(sSql);
      while(rs.next())
      {
        int iId = rs.getInt("ID");
        double d = rs.getDouble("VAL");
        int i1 = rs.getInt("VAL1");
        BigInteger bi2 = rs.getBigDecimal("VAL2").toBigInteger();
        BigDecimal bd3 = rs.getBigDecimal("VAL3");
        System.out.println(String.valueOf(iId)+": "+String.valueOf(d)+", "+String.valueOf(i1)+", "+String.valueOf(bi2)+", "+String.valueOf(bd3));
        Object o = rs.getObject("VAL");
        Object o1 = rs.getObject("VAL1");
        Object o2 = rs.getObject("VAL2");
        Object o3 = rs.getObject("VAL3");
        System.out.println(String.valueOf(iId)+": "+String.valueOf(o)+", "+String.valueOf(o1)+", "+String.valueOf(o2)+", "+String.valueOf(o3));
        System.out.println(String.valueOf(iId)+": "+o.getClass().getName()+", "+o1.getClass().getName()+", "+o2.getClass().getName()+", "+o3.getClass().getName());
      }
      rs.close();
      stmt.close();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  }
 
}