package ch.config.db;

import java.util.List;
import java.util.Map;

public class HistoryDAO extends AbstractDAO{

	public List<Map> selectListHistory() throws Exception{
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT ");
		sb.append("	HISTORY_IDX, ");
		// TODO text값 properties로 관리해야되지 않을까?
		sb.append("	CASE DIV");
		sb.append("		WHEN '0001' THEN '추출'");
		sb.append("		WHEN '0002' THEN '재현'");
		sb.append("		ELSE DIV");
		sb.append("	END AS DIV, ");
		sb.append("	DB_NAME, ");
		sb.append("	DB_CON_URL, ");
		sb.append("	SCHEMA_NAME, ");
		sb.append("	TABLE_COUNT, ");
		// TODO text값 properties로 관리해야되지 않을까?
		sb.append("	CASE EXECUTE_RESULT");
		sb.append("		WHEN 1 THEN '성공'");
		sb.append("		WHEN 0 THEN '실패'");
		sb.append("		ELSE EXECUTE_RESULT");
		sb.append("	END AS EXECUTE_RESULT, ");
		sb.append("	EXECUTE_DATE ");
		sb.append("FROM HISTORY ");
		sb.append("ORDER BY HISTORY_IDX DESC ");

		return selectList(sb.toString());
	}

	public List<Map> selectListHistory(Map<String, String> params) throws Exception{
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT ");
		sb.append("	HISTORY_IDX, ");
		// TODO text값 properties로 관리해야되지 않을까?
		sb.append("	CASE DIV");
		sb.append("		WHEN '0001' THEN '추출'");
		sb.append("		WHEN '0002' THEN '재현'");
		sb.append("		ELSE DIV");
		sb.append("	END AS DIV, ");
		sb.append("	DB_NAME, ");
		sb.append("	DB_CON_URL, ");
		sb.append("	SCHEMA_NAME, ");
		sb.append("	TABLE_COUNT, ");
		// TODO text값 properties로 관리해야되지 않을까?
		sb.append("	CASE EXECUTE_RESULT");
		sb.append("		WHEN 1 THEN '성공'");
		sb.append("		WHEN 0 THEN '실패'");
		sb.append("		ELSE EXECUTE_RESULT");
		sb.append("	END AS EXECUTE_RESULT, ");
		sb.append("	EXECUTE_DATE ");
		sb.append("FROM HISTORY ");
		sb.append("WHERE 1=1 ");
		sb.append("AND DIV = #{div} ");
//		sb.append("AND HISTORY_IDX = ? ");
		sb.append("ORDER BY HISTORY_IDX DESC ");

		return selectList(sb.toString(), params);
	}

	public List<Map> selectListHistoryDetail(Map<String, String> params) throws Exception{
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT ");
		sb.append("	HISTORY_DETAIL_IDX, HISTORY_IDX, TABLE_NAME, TABLE_COLUMN_COUNT, TABLE_RECORD_COUNT ");
		sb.append("FROM HISTORY_DETAIL ");
		sb.append("WHERE HISTORY_IDX = #{history_idx} ");
		sb.append("ORDER BY TABLE_NAME ASC ");

		return selectList(sb.toString(), params);
	}

	public String selectMaxHistoryIdx() throws Exception{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("	CASE ");
		sb.append("		WHEN HISTORY_IDX IS NOT NULL THEN MAX(HISTORY_IDX) + 1 ");
		sb.append("		ELSE 1 ");
		sb.append("	END AS HISTORY_IDX ");
		sb.append("FROM HISTORY ");
		Map<String, String> resultMap = (Map<String, String>)selectByOne(sb.toString());

		return resultMap.get("HISTORY_IDX");
	}

	public Map<String, String> selectHistory() throws Exception{
		String selectSQL = "SELECT idx, date FROM history WHERE idx = ? ";
		Map<String, String> resultMap = (Map<String, String>)selectByOne(selectSQL);
		return resultMap;
	}

	public Map<String, String> selectHistory(Map<String, String> params) throws Exception{
		String selectSQL = "SELECT idx, date FROM history WHERE idx = ? ";
		Map<String, String> resultMap = (Map<String, String>)selectByOne(selectSQL, params);
		return resultMap;
	}

	public void insertHistory() throws Exception{
		StringBuilder sb = new StringBuilder();

		//TODO 테스트 후 하드코딩 => ? 로 바꾸기
		sb.append("INSERT INTO HISTORY(");
		sb.append("	DIV,");
		sb.append("	DB_NAME,");
		sb.append("	DB_CON_URL,");
		sb.append("	SCHEMA_NAME,");
		sb.append("	TABLE_COUNT,");
		sb.append("	EXECUTE_RESULT,");
		sb.append("	EXECUTE_DATE");
		sb.append(")VALUES(");
		sb.append("	'0001',");
		sb.append("	'mysql',");
		sb.append("	'local',");
		sb.append("	'mysql',");
		sb.append("	1,");
		sb.append("	1,");
		sb.append("	datetime('now', 'localtime')");
		sb.append(")");

		insert(sb.toString());
	}

	public void insertHistory(Map<String, String> params) throws Exception{
		StringBuilder sb = new StringBuilder();

		sb.append("INSERT INTO HISTORY(");
		sb.append(" HISTORY_IDX, ");
		sb.append("	DIV, ");
		sb.append("	DB_NAME, ");
		sb.append("	DB_CON_URL, ");
		sb.append("	SCHEMA_NAME, ");
		sb.append("	TABLE_COUNT, ");
		sb.append("	EXECUTE_RESULT, ");
		sb.append("	EXECUTE_DATE ");
		sb.append(")VALUES(");
		sb.append("	#{history_idx}, ");
		sb.append("	#{div}, ");
		sb.append("	#{db_name}, ");
		sb.append("	#{db_con_url}, ");
		sb.append("	#{schema_name}, ");
		sb.append("	#{table_count}, ");
		sb.append("	#{execute_result}, ");
		sb.append("	datetime('now', 'localtime')");
		sb.append(")");

//		params.put("history_idx", selectMaxHistoryIdx());
		insert(sb.toString(), params);

//		insertHistoryDetail(params);

//		if("1".equals(params.get("execute_result"))){
//			insertHistoryDetail(params);
//		}

	}

	public void insertHistoryDetail(Map<String, String> params) throws Exception{
		StringBuilder sb = new StringBuilder();

		sb.append("INSERT INTO HISTORY_DETAIL(");
		sb.append("	HISTORY_IDX, ");
		sb.append("	TABLE_NAME, ");
		sb.append("	TABLE_COLUMN_COUNT, ");
		sb.append("	TABLE_RECORD_COUNT ");
		sb.append(")VALUES(");
		sb.append("	#{history_idx}, ");
		sb.append("	#{table_name}, ");
		sb.append("	#{table_column_count}, ");
		sb.append("	#{table_record_count} ");
		sb.append(")");

		insert(sb.toString(), params);
	}

	public void updateHistory() throws Exception{
		String updateSQL = "UPDATE history SET date = datetime('2002-12-25', 'localtime') WHERE idx = 2 ";
		update(updateSQL);
	}

	public void updateHistory(Map<String, String> params) throws Exception{
		String updateSQL = "UPDATE history SET date = datetime('2002-12-25', 'localtime') WHERE idx = ? ";
		update(updateSQL, params);
	}

	public void deleteHistory() throws Exception{
		String deleteSQL = "DELETE FROM history WHERE idx = 1 ";
		delete(deleteSQL);
	}

	public void deleteHistory(Map<String, String> params) throws Exception{
		String deleteSQL = "DELETE FROM history WHERE idx = ? ";
		delete(deleteSQL, params);
	}

}
