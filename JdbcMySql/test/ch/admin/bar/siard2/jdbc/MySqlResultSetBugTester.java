package ch.admin.bar.siard2.jdbc;

import static org.junit.Assert.*;

import java.sql.*;
import org.junit.*;

import ch.admin.bar.siard2.jdbcx.*;
import ch.enterag.utils.*;
import ch.enterag.utils.base.*;

public class MySqlResultSetBugTester
{
  private static final ConnectionProperties _cp = new ConnectionProperties();
  private static final String _sDB_URL = MySqlDriver.getUrl(_cp.getHost() + ":" + _cp.getPort()+"/bugdb",true);
  private static final String _sDB_USER = "buguser";
  private static final String _sDB_PASSWORD = "bugpwd";
  /***
  private static final String _sDBA_USER = _cp.getDbaUser();
  private static final String _sDBA_PASSWORD = _cp.getDbaPassword();
  ***/
  
  private Connection _conn = null;
  private ResultSet _rs = null;
  private ResultSet getResultSet() { return _rs; }
  private void setResultSet(ResultSet rs) { _rs = rs; }
  
  private Connection closeResultSet()
    throws SQLException
  {
    ResultSet rs = getResultSet();
    if (rs != null)
    {
      if (!rs.isClosed())
      {
        Statement stmt = rs.getStatement();
        rs.close();
        setResultSet(null);
        if (!stmt.isClosed())
          stmt.close();
        _conn.commit();
      }
    }
    return _conn;
  } /* closeResultSet */
  
  private boolean openResultSet(String sQuery, int iType, int iConcurrency)
    throws SQLException
  {
    closeResultSet();
    Statement stmt = _conn.createStatement(iType,iConcurrency);
    ResultSet rs = stmt.executeQuery(sQuery);
    // it is always TYPE_FORWARD_ONLY
    // assertEquals("Invalid result set type!",iType,rs.getType());
    assertEquals("Invalid result set concurrency!",iConcurrency,rs.getConcurrency());
    // assertEquals("Invalid result set holdability",ResultSet.CLOSE_CURSORS_AT_COMMIT,rs.getHoldability());
    setResultSet(rs);
    return rs.next();
  } /* openResultSet */
  
  @Before
  public void setUp() {
    try 
    {
      MySqlDataSource dsMySql = new MySqlDataSource();
      dsMySql.setUrl(_sDB_URL);
      dsMySql.setUser(_sDB_USER);
      dsMySql.setPassword(_sDB_PASSWORD);
      _conn = dsMySql.getConnection();
      _conn.setAutoCommit(false);
      //openResultSet(_sSqlQuerySimple,ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  }
  
  @After
  public void tearDown()
  {
    try
    {
      closeResultSet();
      if (!_conn.isClosed())
      {
        _conn.commit();
        _conn.close();
      }
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* tearDown */
  
  @Test
  public void testInsertRow() throws SQLException
  {
    try 
    {
      Statement stmt = _conn.createStatement();
      stmt.executeUpdate("DELETE FROM bugdb.pages_classified_food WHERE Country_Id = 4 and Crawl_Nr = 3");
      _conn.commit();
      
      openResultSet("SELECT Country_ID, Crawl_Nr, URL FROM pages_classified_food",ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
      getResultSet().moveToInsertRow();
      getResultSet().updateObject("Country_ID",4l);
      getResultSet().updateObject("Crawl_Nr",3l);
      //getResultSet().updateObject("URL","http://www.foodsmatter.com/allergy_intolerance/cow's_milk_allergy_general/index_cow's_milk_general.html");
      getResultSet().updateObject("URL","a'b");
      getResultSet().insertRow(); // it works but throws an exception!
      System.out.println("It worked!");
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testInsertRow */
  
  

}
