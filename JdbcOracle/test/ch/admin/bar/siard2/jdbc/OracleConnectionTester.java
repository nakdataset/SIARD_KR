package ch.admin.bar.siard2.jdbc;

import java.sql.*;
import static org.junit.Assert.*;
import org.junit.*;
import ch.enterag.utils.*;
import ch.enterag.sqlparser.identifier.*;
import ch.enterag.utils.base.*;
import ch.enterag.utils.jdbc.*;
import ch.admin.bar.siard2.jdbcx.*;
import ch.admin.bar.siard2.oracle.*;

public class OracleConnectionTester  extends BaseConnectionTester
{
  private static final ConnectionProperties _cp = new ConnectionProperties();   
  private static final String _sDB_URL = OracleDriver.getUrl(_cp.getHost()+":"+_cp.getPort()+":"+_cp.getInstance());
  private static final String _sDBA_USER = _cp.getDbaUser();
  private static final String _sDBA_PASSWORD = _cp.getDbaPassword();
  private static final String _sDB_USER = _cp.getUser();
  private static final String _sDB_PASSWORD = _cp.getPassword();

  private OracleConnection _connOracle = null;

  @BeforeClass
  public static void setUpClass()
  {
    try 
    { 
      OracleDataSource dsOracle = new OracleDataSource();
      dsOracle.setUrl(_sDB_URL);
      dsOracle.setUser(_sDBA_USER);
      dsOracle.setPassword(_sDBA_PASSWORD);
      OracleConnection connOracle = (OracleConnection)dsOracle.getConnection();
      /** drop and create the test user
      try { TestOracleDatabase.dropUser(connOracle, _sDB_USER); }
      catch(SQLException se) {}
      TestOracleDatabase.createUser(connOracle, _sDB_USER, _sDB_PASSWORD);
      **/
      /* drop and create the test databases */
      new TestOracleDatabase(connOracle);
      TestOracleDatabase.grantSchema(connOracle, TestOracleDatabase._sTEST_SCHEMA, _sDB_USER);
      new TestSqlDatabase(connOracle);
      TestOracleDatabase.grantSchema(connOracle, TestSqlDatabase._sTEST_SCHEMA, _sDB_USER);
      connOracle.close();
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* setUpClass */
  
  @Before
  public void setUp()
  {
    try 
    { 
      OracleDataSource dsOracle = new OracleDataSource();
      dsOracle.setUrl(_sDB_URL);
      dsOracle.setUser(_sDB_USER);
      dsOracle.setPassword(_sDB_PASSWORD);
      _connOracle = (OracleConnection)dsOracle.getConnection();
      _connOracle.setAutoCommit(false);
      setConnection(_connOracle);
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* setUp */
  
  @Test
  public void testClass()
  {
    assertEquals("Wrong connection class!", OracleConnection.class, _connOracle.getClass());
  } /* testClass */

  @Test
  @Override
  public void testRollback()
  {
    enter();
    try 
    {
      _connOracle.setAutoCommit(false);
      _connOracle.rollback(); 
    }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testRollback */
  
  @Test
  public void testSetSavepoint()
  {
    enter();
    try 
    { 
      _connOracle.setAutoCommit(false);
      _connOracle.setSavepoint();
    }
    catch(SQLFeatureNotSupportedException sfnse) { System.out.println(EU.getExceptionMessage(sfnse)); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testSetSavepoint */
  
  @Test
  public void testSetSavepoint_String()
  {
    enter();
    try 
    { 
      _connOracle.setAutoCommit(false);
      _connOracle.setSavepoint("TEST_SAVEPOINT"); 
    }
    catch(SQLFeatureNotSupportedException sfnse) { System.out.println(EU.getExceptionMessage(sfnse)); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testSetSavepoint_String */
  
  @Test
  public void testRollback_Savepoint()
  {
    enter();
    try
    {
      _connOracle.setAutoCommit(false);
      Savepoint sp = _connOracle.setSavepoint();
      _connOracle.rollback(sp);
    }
    catch(SQLFeatureNotSupportedException sfnse) { System.out.println(EU.getExceptionMessage(sfnse)); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testRollback_SavePoint */
  
  @Test
  public void testReleaseSavePoint()
  {
    enter();
    try 
    { 
      _connOracle.setAutoCommit(false);
      Savepoint sp = _connOracle.setSavepoint();
      _connOracle.releaseSavepoint(sp);
    }
    catch(SQLFeatureNotSupportedException sfnse) { System.out.println(EU.getExceptionMessage(sfnse)); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testReleaseSavePoint */
  
  @Test
  public void testCreateStruct()
  {
    enter();
    try 
    {
      QualifiedId qiStructType = new QualifiedId(null,TestOracleDatabase._sTEST_SCHEMA,TestOracleDatabase._sUDT_OBJECT);
      _connOracle.createStruct(qiStructType.format(), new Object[] {"Label", Double.valueOf(3.14159)}); 
    }
    catch(SQLFeatureNotSupportedException sfnse) { System.out.println(EU.getExceptionMessage(sfnse)); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testCreateStruct */
  
  @Test
  public void testCreateArrayOf()
  {
    enter();
    try 
    {
      Array array = _connOracle.createArrayOf("VARCHAR(25)", new String[] {"a", "ab", "abc"});
      array.free();
    }
    catch(SQLFeatureNotSupportedException sfnse) { System.out.println(EU.getExceptionMessage(sfnse)); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* createArrayOf */
  
  @Test
  public void testCreateSqlXml()
  {
    enter();
    try 
    {
      SQLXML sqlxml = _connOracle.createSQLXML(); 
      sqlxml.free();
    }
    catch(SQLFeatureNotSupportedException sfnse) { System.out.println(EU.getExceptionMessage(sfnse)); }
    catch(SQLException se) { fail(EU.getExceptionMessage(se)); }
  } /* testCreateSqlXml */

}
