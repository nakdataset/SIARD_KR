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
				LOG.info("db 파일 경로 생성 성공 => " + dbFilePath);
			}catch(Exception e) {
				LOG.error("db 파일 경로 생성 실패");
			}

			try {
				Class.forName("org.sqlite.JDBC");
				LOG.info("드라이버 로딩 성공");
			}catch(Exception e) {
				LOG.error("드라이버 로딩 실패");
			}

			String dbConnectionURL = "jdbc:sqlite:" + dbFilePath + File.separator + DATABASE_FILE_NAME;
			try {
				// 읽기 전용
				/*
				SQLiteConfig config = new SQLiteConfig();
				config.setReadOnly(true);
				conn = DriverManager.getConnection(dbConnectionURL, config.toProperties());
				*/
//				conn = DriverManager.getConnection("jdbc:sqlite:db\testCCG.db");
				conn = DriverManager.getConnection(dbConnectionURL);
				LOG.info("DB 연결 성공 => " + dbConnectionURL);
			}catch(Exception e) {
				LOG.error("DB 연결 실패 => " + dbConnectionURL);
			}

			return conn;
		}

	  }
}
