package ch.config.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AbstractDAO {

	protected Log log = LogFactory.getLog(AbstractDAO.class);

	private Connection conn = SQLiteConnection.getConnection();

	private List<String> fields = new ArrayList<String>();

	protected void printQueryId(String queryId) {
//		if(log.isDebugEnabled()){
			log.info("Query \t: " + queryId);
//		}
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public List selectList(String query) throws Exception {
		printQueryId(query);

		List resultList = new ArrayList();
		Map<String, String> resultMap = new HashMap<String, String>();

		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();

		int cols = rsmd.getColumnCount();

		while(rs.next()) {
			resultMap = new HashMap<String, String>();

			for(int i=1; i<=cols; i++) {
				resultMap.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
			}
			resultList.add(resultMap);
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		return resultList;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public List selectList(String query, Map<String, String> params) throws Exception {
		printQueryId(query);

		List resultList = new ArrayList();
		Map<String, String> resultMap = new HashMap<String, String>();

		query = initQueryDataBinding(query);
		PreparedStatement pstmt = conn.prepareStatement(query);
		initParam(pstmt, params);

		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();

		int cols = rsmd.getColumnCount();

		while(rs.next()) {
			resultMap = new HashMap<String, String>();

			for(int i=1; i<=cols; i++) {
				resultMap.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
			}
			resultList.add(resultMap);
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		return resultList;
	}

	public Object selectByOne(String query) throws Exception {
		printQueryId(query);

		Map<String, String> resultMap = new HashMap<String, String>();
		PreparedStatement pstmt = conn.prepareStatement(query);

		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();

		int cols = rsmd.getColumnCount();

		if(rs.next()) {
			resultMap = new HashMap<String, String>();

			for(int i=1; i<=cols; i++) {
				resultMap.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
			}
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		return resultMap;
	}

	public Object selectByOne(String query, Map<String, String> params) throws Exception {
		printQueryId(query);

		Map<String, String> resultMap = new HashMap<String, String>();
		PreparedStatement pstmt = conn.prepareStatement(query);

		initParam(pstmt, params);

		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();

		int cols = rsmd.getColumnCount();

		if(rs.next()) {
			resultMap = new HashMap<String, String>();

			for(int i=1; i<=cols; i++) {
				resultMap.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
			}
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		return resultMap;
	}

	public Object insert(String query) throws Exception {
		printQueryId(query);

		PreparedStatement pstmt = conn.prepareStatement(query);
		int cnt = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();
		return cnt;
	}

	public Object insert(String query, Map<String, String> params) throws Exception {
		printQueryId(query);

		query = initQueryDataBinding(query);
		PreparedStatement pstmt = conn.prepareStatement(query);
		initParam(pstmt, params);
		int cnt = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();
		return cnt;
	}


	public Object update(String query) throws Exception {
		printQueryId(query);

		PreparedStatement pstmt = conn.prepareStatement(query);
		int cnt = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();
		return cnt;
	}

	public Object update(String query, Map<String, String> params) throws Exception {
		printQueryId(query);

		PreparedStatement pstmt = conn.prepareStatement(query);
		initParam(pstmt, params);
		int cnt = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();
		return cnt;
	}

	public Object delete(String query) throws Exception {
		printQueryId(query);

		PreparedStatement pstmt = conn.prepareStatement(query);
		int cnt = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();
		return cnt;
	}

	public Object delete(String query, Map<String, String> params) throws Exception {
		printQueryId(query);

		PreparedStatement pstmt = conn.prepareStatement(query);
		initParam(pstmt, params);
		int cnt = pstmt.executeUpdate();
		if(pstmt != null) pstmt.close();
		return cnt;
	}

	void initParam(PreparedStatement pstmt, Map<String, String> params) throws Exception{

		Iterator<String> iter = params.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String value = params.get(key);

			if(fields.indexOf(key)+1 > 0) {
				pstmt.setString(fields.indexOf(key)+1, value);
			}
		}
	}

	String initQueryDataBinding(String query) {
		fields = new ArrayList<String>();
		int pos;
        while((pos = query.indexOf("#{")) != -1) {
            int end = query.substring(pos).indexOf("}");
            if (end == -1) {
            	end = query.length();
            }else {
            	end += pos;
            }
            fields.add(query.substring(pos+2,end));
            query = query.substring(0, pos) + "?" + query.substring(end+1);
        }
        return query;
	}

	//TODO 테스트
	void test() {
		// 테이블 생성
		try {
            Statement stmt = conn.createStatement();

//			String sql = "CREATE TABLE IF NOT EXISTS history (\n"
//                + "	idx integer PRIMARY KEY AUTOINCREMENT,\n"
//                + "	date text\n"
//                + ");";

            String dropTableHistorySQL = "drop table HISTORY";
            stmt.execute(dropTableHistorySQL);
            String dropTableHISTORYDETAILSQL = "drop table HISTORY_DETAIL";
            stmt.execute(dropTableHISTORYDETAILSQL);

            String createTableHistory = "";
            createTableHistory += "CREATE TABLE IF NOT EXISTS HISTORY(";
    		createTableHistory += "   HISTORY_IDX integer PRIMARY KEY AUTOINCREMENT,";
    		createTableHistory += "   DIV text,";
    		createTableHistory += "   DB_NAME text,";
    		createTableHistory += "   DB_CON_URL text,";
    		createTableHistory += "   SCHEMA_NAME text,";
    		createTableHistory += "   TABLE_COUNT text,";
    		createTableHistory += "   EXECUTE_RESULT text,";
    		createTableHistory += "   EXECUTE_DATE text";
    		createTableHistory += ")";
			stmt.execute(createTableHistory);

			String createTableHistoryDetail = "";
			createTableHistoryDetail += "CREATE TABLE IF NOT EXISTS HISTORY_DETAIL(";
			createTableHistoryDetail += "	HISTORY_DETAIL_IDX integer PRIMARY KEY AUTOINCREMENT,";
			createTableHistoryDetail += "	HISTORY_IDX integer,";
			createTableHistoryDetail += "	TABLE_NAME text,";
			createTableHistoryDetail += "	TABLE_COLUMN_COUNT integer,";
			createTableHistoryDetail += "	TABLE_RECORD_COUNT integer,";
			createTableHistoryDetail += "	PERFORM_TIME integer";
			createTableHistoryDetail += ")";
			stmt.execute(createTableHistoryDetail);
		}catch(Exception e) {
			e.printStackTrace();
		}

		// DDL
		try {

			//Insert
			AbstractDAO dao = new AbstractDAO();

			String insertSQL = "INSERT INTO history(date) values(datetime('now', 'localtime')) ";
			dao.insert(insertSQL);

			//Update
			String updateSQL = "UPDATE history SET date = datetime('2002-12-25', 'localtime') WHERE idx = 2 ";
			dao.update(updateSQL);

			String updateSQL2 = "UPDATE history SET date = datetime(?, 'localtime') WHERE idx = ? ";
			Map<String, String> params = new LinkedHashMap<String, String>();
			params.put("date", "1900-01-01");
			params.put("idx", "3");
			dao.update(updateSQL2, params);

			//Delete
			String deleteSQL = "DELETE FROM history WHERE idx = 1 ";
			dao.delete(deleteSQL);

			//SelectList
			String selectListSQL = "SELECT idx, date FROM history ";
			List<Map> resultList = dao.selectList(selectListSQL);

			//Select
			String selectSQL = "SELECT idx, date FROM history WHERE idx = ? ";
			Map<String, String> selectParams = new LinkedHashMap<String, String>();
			selectParams.put("idx", "2");
			Map<String, String> resultMap = (Map<String, String>) dao.selectByOne(selectSQL, selectParams);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
