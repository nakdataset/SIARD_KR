package ch.config.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class SQLiteConnection {

	public static Connection getConnection() {
	    return LazyHolder.getConnection();
	  }

	private static class LazyHolder {
		private static final Logger LOG = Logger.getLogger(LazyHolder.class);
		private static final String DATABASE_FILE_PATH = "db";
		private static final String DATABASE_FILE_NAME = "siard.db";

	    private static Connection conn = null;

		public static Connection getConnection() {

			if(conn != null) return conn;

			String rootPath = System.getProperty("user.dir");
			File dbFilePath = new File(rootPath + File.separator + DATABASE_FILE_PATH);
			try {
				rootPath = System.getProperty("user.dir");
				dbFilePath = new File(rootPath + File.separator + DATABASE_FILE_PATH);
				if(!dbFilePath.exists()) {
					dbFilePath.mkdirs();
				}
				LOG.info("DB file creation completed => " + dbFilePath);
			}catch(Exception e) {
				LOG.error("DB file creation failure");
			}

			try {
				Class.forName("org.sqlite.JDBC");
				LOG.info("Driver loading success");
			}catch(Exception e) {
				LOG.error("Driver loading failure");
			}

			String dbConnectionURL = "jdbc:sqlite:" + dbFilePath + File.separator + DATABASE_FILE_NAME;
			try {
				conn = DriverManager.getConnection(dbConnectionURL);
				LOG.info("DB connection success => " + dbConnectionURL);
			}catch(Exception e) {
				LOG.error("DB connection failure => " + dbConnectionURL);
			}

			return conn;
		}

	  }
}
