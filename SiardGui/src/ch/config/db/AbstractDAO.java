package ch.config.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AbstractDAO {

	protected Log log = LogFactory.getLog(AbstractDAO.class);

	private Connection conn = SQLiteConnection.getConnection();

	private List<String> fields = new ArrayList<String>();

	protected void printQueryId(String queryId) {
		log.info("Query \t: " + queryId);
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

}
