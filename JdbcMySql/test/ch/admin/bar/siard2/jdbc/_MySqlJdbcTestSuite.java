package ch.admin.bar.siard2.jdbc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	MySqlDriverTester.class, 
	MySqlConnectionTester.class, 
	MySqlDatabaseMetaDataTester.class, 
	MySqlResultSetMetaDataTester.class,
	MySqlResultSetTester.class,
	MySqlStatementTester.class
})
public class _MySqlJdbcTestSuite {

}
