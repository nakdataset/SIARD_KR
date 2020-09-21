package ch.config.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteConnection {

	public static Connection getConnection() {
	    return LazyHolder.getConnection();
	  }

	private static class LazyHolder {
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
				System.out.println("DB file creation completed => " + dbFilePath);
			}catch(Exception e) {
				System.out.println("DB file creation failure");
			}

			try {
				Class.forName("org.sqlite.JDBC");
				System.out.println("Driver loading success");
			}catch(Exception e) {
				System.out.println("Driver loading failure");
			}

			String dbConnectionURL = "jdbc:sqlite:" + dbFilePath + File.separator + DATABASE_FILE_NAME;
			try {
				conn = DriverManager.getConnection(dbConnectionURL);
				System.out.println("DB connection success => " + dbConnectionURL);
			}catch(Exception e) {
				System.out.println("DB connection failure => " + dbConnectionURL);
			}

			return conn;
		}

	  }
}
