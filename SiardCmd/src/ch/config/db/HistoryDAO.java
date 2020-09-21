package ch.config.db;

import java.util.Map;

public class HistoryDAO extends AbstractDAO{

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

		insert(sb.toString(), params);

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

}
