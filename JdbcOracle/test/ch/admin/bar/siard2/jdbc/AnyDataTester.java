package ch.admin.bar.siard2.jdbc;

import java.sql.*;
import static org.junit.Assert.*;
import org.junit.*;
import ch.admin.bar.siard2.jdbcx.*;
import ch.enterag.utils.*;
import ch.enterag.utils.base.*;
import ch.enterag.utils.jdbc.*;

public class AnyDataTester 
{
  private static final ConnectionProperties _cp = new ConnectionProperties();   
  private static final String _sDB_URL = OracleDriver.getUrl(_cp.getHost()+":"+_cp.getPort()+":"+_cp.getInstance());
  private static final String _sDB_USER = "DIGIT_B2";
  private static final String _sDB_PASSWORD = "DIGIT_B2";
  
  private Connection _conn = null;

  @Before
  public void setUp() 
  {
    try {
      OracleDataSource dsOracle = new OracleDataSource();
      dsOracle.setUrl(_sDB_URL);
      dsOracle.setUser(_sDB_USER);
      dsOracle.setPassword(_sDB_PASSWORD);
      _conn = dsOracle.getConnection();
      _conn.setAutoCommit(false);
    }
    catch(SQLException se) { fail(se.getClass().getName()+": " + se.getMessage()); }
  }

  
  @Test
  public void testGetColumns() 
  {
    try
    {
      DatabaseMetaData dmd = _conn.getMetaData();
      ResultSet rs = dmd.getColumns(null, _sDB_USER, "IFS_IN_TABLE", "%");
      BaseDatabaseMetaDataTester.print(rs);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  }

  @Test
  public void testGetObject() 
  {
    try
    {
      Statement stmt = _conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT USER_PROP FROM IFS_IN_TABLE");
      while (rs.next())
      {
        Object o = rs.getObject(1);
        System.out.println(String.valueOf(o));
      }
      rs.close();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  }

  @Test
  public void testGetClob() 
  {
    try
    {
      Statement stmt = _conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT USER_PROP FROM IFS_IN_TABLE");
      while (rs.next())
      {
        Clob clob = rs.getClob(1);
        System.out.println(clob.getSubString(1, (int)clob.length()));
      }
      rs.close();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  }

}
