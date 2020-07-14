package ch.admin.bar.siard2.jdbc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	OracleDriverTester.class,
	OracleConnectionTester.class,
	OracleDatabaseMetaDataTester.class,
	OracleResultSetMetaDataTester.class,
	OracleResultSetTester.class,
  OracleStatementTester.class
})
public class _OracleJdbcTestSuite {

}
