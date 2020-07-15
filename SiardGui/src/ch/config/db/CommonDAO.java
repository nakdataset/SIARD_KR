package ch.config.db;

import java.util.List;
import java.util.Map;

public class CommonDAO extends AbstractDAO{

	public List<Map> selectListHistory() throws Exception{
		String selectListSQL = "SELECT idx, date FROM history ";
		List<Map> resultList = selectList(selectListSQL);
		return resultList;
	}

	public List<Map> selectListHistory(Map<String, String> params) throws Exception{
		String selectListSQL = "SELECT idx, date FROM history ";
		List<Map> resultList = selectList(selectListSQL, params);
		return resultList;
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
		String insertSQL = "INSERT INTO history(date) values(datetime('now', 'localtime')) ";
		insert(insertSQL);
	}

	public void insertHistory(Map<String, String> params) throws Exception{
		String insertSQL = "INSERT INTO history(date) values(datetime(?, 'localtime')) ";
		insert(insertSQL, params);
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
