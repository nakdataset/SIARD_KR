package ch.config.db;

import java.util.List;
import java.util.Map;

import ch.admin.bar.siard2.gui.SiardBundle;

public class HistoryDAO extends AbstractDAO{

	public List<Map> selectListHistory() throws Exception{
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT ");
		sb.append("	HISTORY_IDX, ");
		sb.append("	CASE DIV");
		sb.append("		WHEN '0001' THEN '" + SiardBundle.getSiardBundle().getHistoryDivDownload() + "'");
		sb.append("		WHEN '0002' THEN '" + SiardBundle.getSiardBundle().getHistoryDivUpload() + "'");
		sb.append("		ELSE DIV");
		sb.append("	END AS DIV, ");
		sb.append("	DB_NAME, ");
		sb.append("	DB_CON_URL, ");
		sb.append("	SCHEMA_NAME, ");
		sb.append("	TABLE_COUNT, ");
		sb.append("	CASE EXECUTE_RESULT");
		sb.append("		WHEN (SELECT COUNT(1) FROM HISTORY_DETAIL X WHERE X.HISTORY_IDX = HISTORY_IDX AND X.EXECUTE_RESULT = 0 ) > 0 THEN '" + SiardBundle.getSiardBundle().getHistoryExecuteReulstSuccess() + "'");
		sb.append("		ELSE '" + SiardBundle.getSiardBundle().getHistoryExecuteReulstFail() + "'");
		sb.append("	END AS EXECUTE_RESULT, ");
		sb.append("	EXECUTE_DATE ");
		sb.append("FROM HISTORY ");
		sb.append("ORDER BY HISTORY_IDX DESC ");

		return selectList(sb.toString());
	}

	public List<Map> selectListHistory(Map<String, String> params) throws Exception{
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT ");
		sb.append("	A.HISTORY_IDX, ");
		sb.append("	CASE A.DIV");
		sb.append("		WHEN '0001' THEN '" + SiardBundle.getSiardBundle().getHistoryDivDownload() + "'");
		sb.append("		WHEN '0002' THEN '" + SiardBundle.getSiardBundle().getHistoryDivUpload() + "'");
		sb.append("		ELSE A.DIV");
		sb.append("	END AS DIV, ");
		sb.append("	A.DB_NAME, ");
		sb.append("	A.DB_CON_URL, ");
		sb.append("	A.SCHEMA_NAME, ");
		sb.append("	A.TABLE_COUNT, ");
		sb.append("	CASE ");
		sb.append("		WHEN (SELECT COUNT(1) FROM HISTORY_DETAIL X WHERE X.HISTORY_IDX = A.HISTORY_IDX AND X.EXECUTE_RESULT = 0 ) < 1 THEN '" + SiardBundle.getSiardBundle().getHistoryExecuteReulstSuccess() + "'");
		sb.append("		ELSE '" + SiardBundle.getSiardBundle().getHistoryExecuteReulstFail() + "'");
		sb.append("	END AS EXECUTE_RESULT, ");
		sb.append("	A.EXECUTE_DATE ");
		sb.append("FROM HISTORY A ");
		sb.append("WHERE 1=1 ");
		sb.append("AND A.DIV = #{div} ");
		sb.append("ORDER BY A.HISTORY_IDX DESC ");

		return selectList(sb.toString(), params);
	}

	public List<Map> selectListHistoryDetail(Map<String, String> params) throws Exception{
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT ");
		sb.append("	HISTORY_DETAIL_IDX, ");
		sb.append("	HISTORY_IDX, ");
		sb.append("	TABLE_NAME, ");
		sb.append("	TABLE_COLUMN_COUNT, ");
		sb.append("	TABLE_RECORD_COUNT, ");
		sb.append("	CASE EXECUTE_RESULT ");
		sb.append("		WHEN 1 THEN '" + SiardBundle.getSiardBundle().getHistoryExecuteReulstSuccess() + "'");
		sb.append("		WHEN 0 THEN '" + SiardBundle.getSiardBundle().getHistoryExecuteReulstFail() + "'");
		sb.append("		ELSE EXECUTE_RESULT ");
		sb.append("	END AS EXECUTE_RESULT ");
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

//	public void insertHistory(Map<String, String> params) throws Exception{
//		StringBuilder sb = new StringBuilder();
//
//		sb.append("INSERT INTO HISTORY(");
//		sb.append(" HISTORY_IDX, ");
//		sb.append("	DIV, ");
//		sb.append("	DB_NAME, ");
//		sb.append("	DB_CON_URL, ");
//		sb.append("	SCHEMA_NAME, ");
//		sb.append("	TABLE_COUNT, ");
//		sb.append("	EXECUTE_RESULT, ");
//		sb.append("	EXECUTE_DATE ");
//		sb.append(")VALUES(");
//		sb.append("	#{history_idx}, ");
//		sb.append("	#{div}, ");
//		sb.append("	#{db_name}, ");
//		sb.append("	#{db_con_url}, ");
//		sb.append("	#{schema_name}, ");
//		sb.append("	#{table_count}, ");
//		sb.append("	#{execute_result}, ");
//		sb.append("	datetime('now', 'localtime')");
//		sb.append(")");
//
//		insert(sb.toString(), params);
//
//	}
//
//	public void insertHistoryDetail(Map<String, String> params) throws Exception{
//		StringBuilder sb = new StringBuilder();
//
//		sb.append("INSERT INTO HISTORY_DETAIL(");
//		sb.append("	HISTORY_IDX, ");
//		sb.append("	TABLE_NAME, ");
//		sb.append("	TABLE_COLUMN_COUNT, ");
//		sb.append("	TABLE_RECORD_COUNT, ");
//		sb.append("	EXECUTE_RESULT ");
//		sb.append(")VALUES(");
//		sb.append("	#{history_idx}, ");
//		sb.append("	#{table_name}, ");
//		sb.append("	#{table_column_count}, ");
//		sb.append("	#{table_record_count}, ");
//		sb.append("	#{execute_result} ");
//		sb.append(")");
//
//		insert(sb.toString(), params);
//	}

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
