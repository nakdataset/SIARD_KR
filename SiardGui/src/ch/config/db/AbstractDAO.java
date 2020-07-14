package ch.config.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AbstractDAO {

	private Connection conn = SQLiteConnection.getConnection();

	@SuppressWarnings({"unchecked", "rawtypes"})
	public List selectList(String query, LinkedHashMap<String, String> params) throws Exception {
		List resultList = new ArrayList();
		Map<String, String> resultMap = new HashMap<String, String>();

		PreparedStatement pstmt = conn.prepareStatement(query);
		initParam(pstmt, params);

		ResultSet rs = pstmt.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();

		int cols = rsmd.getColumnCount();

		while(rs.next()) {
			resultMap = new HashMap<String, String>();

			for(int i=0; i<=cols; i++) {
				resultMap.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
			}
			resultList.add(resultMap);
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		return resultList;
	}

	public Object selectByOne(String query, LinkedHashMap<String, String> params) throws Exception {
		Map<String, String> resultMap = new HashMap<String, String>();
		PreparedStatement pstmt = conn.prepareStatement(query);

		initParam(pstmt, params);

		ResultSet rs = pstmt.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();

		int cols = rsmd.getColumnCount();

		if(rs.next()) {
			resultMap = new HashMap<String, String>();

			for(int i=0; i<=cols; i++) {
				resultMap.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
			}
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		return resultMap;
	}

	public Object insert(String query, LinkedHashMap<String, String> params) throws Exception {
		PreparedStatement pstmt = conn.prepareStatement(query);

		initParam(pstmt, params);

		int cnt = pstmt.executeUpdate();

		if(pstmt != null) pstmt.close();

		return cnt;
	}

	public Object update(String query, LinkedHashMap<String, String> params) throws Exception {
		PreparedStatement pstmt = conn.prepareStatement(query);

		initParam(pstmt, params);

		int cnt = pstmt.executeUpdate();

		if(pstmt != null) pstmt.close();

		return cnt;
	}

	public Object delete(String query, LinkedHashMap<String, String> params) throws Exception {
		PreparedStatement pstmt = conn.prepareStatement(query);

		initParam(pstmt, params);

		int cnt = pstmt.executeUpdate();

		if(pstmt != null) pstmt.close();

		return cnt;
	}

	void initParam(PreparedStatement pstmt, LinkedHashMap<String, String> params) throws Exception{
		int setIndex = 0;
		Iterator<String> iter = params.keySet().iterator();

		while (iter.hasNext()) {
			String key = iter.next();
			String value = params.get(key);
			pstmt.setString(++setIndex, value);
		}
	}
}
