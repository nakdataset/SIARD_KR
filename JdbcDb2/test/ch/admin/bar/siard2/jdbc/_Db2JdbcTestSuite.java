package ch.admin.bar.siard2.jdbc;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses(
  {
    Db2ConnectionTester.class,
    Db2DatabaseMetaDataTester.class,
    Db2DriverTester.class,
    Db2ResultSetMetaDataTester.class,
    Db2ResultSetTester.class,
    Db2StatementTester.class
  })
public class _Db2JdbcTestSuite
{
}
