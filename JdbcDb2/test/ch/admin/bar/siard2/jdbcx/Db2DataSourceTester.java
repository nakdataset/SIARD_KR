package ch.admin.bar.siard2.jdbcx;

import java.sql.*;
import javax.sql.*;
import static org.junit.Assert.*;
import org.junit.*;
import ch.enterag.utils.base.*;

public class Db2DataSourceTester
{
  private static final ConnectionProperties _cp = new ConnectionProperties();
  private static final String _sDB_URL = "jdbc:db2://"+_cp.getHost()+":"+_cp.getPort()+"/"+_cp.getCatalog();
  private static final String _sDB_USER = _cp.getUser();
  private static final String _sDB_PASSWORD = _cp.getPassword();

  private Db2DataSource _dsDb2 = null;
  private Connection _conn = null;
  
  @Before
  public void setUp()
  {
    try
    {
      _dsDb2 = new Db2DataSource();
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* setUp */
  
  @After
  public void tearDown()
  {
    try
    {
      if ((_conn != null) && (!_conn.isClosed()))
        _conn.close();
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* tearDown */

  @Test
  public void testWrapper()
  {
    try
    {
      Assert.assertSame("Invalid wrapper!", true, _dsDb2.isWrapperFor(DataSource.class));
      DataSource dsWrapped = _dsDb2.unwrap(DataSource.class);
      assertSame("Invalid wrapped class!", com.ibm.db2.jcc.DB2SimpleDataSource.class, dsWrapped.getClass());
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* testWrapper */
  
  @Test
  public void testLoginTimeout()
  {
    try
    {
      int iLoginTimeout = _dsDb2.getLoginTimeout();
      assertSame("Unexpected login timeout "+String.valueOf(iLoginTimeout)+"!", 0, iLoginTimeout);
    }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* testLoginTimeout */
  
  @Test
  public void testConnection()
  {
    _dsDb2.setUrl(_sDB_URL);
    _dsDb2.setUser(_sDB_USER);
    _dsDb2.setPassword(_sDB_PASSWORD);
    try { _conn = _dsDb2.getConnection(); }
    catch(SQLException se) { fail(se.getClass().getName()+": "+se.getMessage()); }
  } /* testConnection */

}
