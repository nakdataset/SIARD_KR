package ch.admin.bar.siard2.jdbc;

import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses(
  {
    H2DriverTester.class,
    H2ArrayTester.class,
    H2ConnectionTester.class,
    H2DatabaseMetaDataTester.class,
    H2ResultSetMetaDataTester.class,
    H2ResultSetTester.class,
    H2SqlXmlTester.class,
    H2StatementTester.class
  })
public class _H2JdbcTestSuite
{
}
