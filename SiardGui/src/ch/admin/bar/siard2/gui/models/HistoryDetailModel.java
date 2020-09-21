package ch.admin.bar.siard2.gui.models;

import java.util.Map;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class HistoryDetailModel {

	private SimpleIntegerProperty history_detail_idx;
	private SimpleIntegerProperty history_idx;
	private SimpleStringProperty table_name;
	private SimpleIntegerProperty table_column_count;
	private SimpleIntegerProperty table_record_count;
	private SimpleStringProperty execute_result;

	public HistoryDetailModel(){}

	public HistoryDetailModel(SimpleIntegerProperty history_detail_idx, SimpleIntegerProperty history_idx, SimpleStringProperty table_name, SimpleIntegerProperty table_column_count, SimpleIntegerProperty table_record_count, SimpleStringProperty execute_result) {
		super();
		this.history_detail_idx = history_detail_idx;
		this.history_idx = history_idx;
		this.table_name = table_name;
		this.table_column_count = table_column_count;
		this.table_record_count = table_record_count;
		this.execute_result = execute_result;
	}

	public int getHistory_detail_idx() {
		return history_detail_idx.get();
	}

	public void setHistory_detail_idx(SimpleIntegerProperty history_detail_idx) {
		this.history_detail_idx = history_detail_idx;
	}

	public int getHistory_idx() {
		return history_idx.get();
	}

	public void setHistory_idx(SimpleIntegerProperty history_idx) {
		this.history_idx = history_idx;
	}

	public String getTable_name() {
		return table_name.get();
	}

	public void setTable_name(SimpleStringProperty table_name) {
		this.table_name = table_name;
	}

	public int getTable_column_count() {
		return table_column_count.get();
	}

	public void setTable_column_count(SimpleIntegerProperty table_column_count) {
		this.table_column_count = table_column_count;
	}


	public int getTable_record_count() {
		return table_record_count.get();
	}

	public void setTable_record_count(SimpleIntegerProperty table_record_count) {
		this.table_record_count = table_record_count;
	}

	public String getExecute_result() {
		return execute_result.get();
	}

	public void setExecute_result(SimpleStringProperty execute_result) {
		this.execute_result = execute_result;
	}

	@Override
	public String toString() {
		return "HistoryDetailModel [history_detail_idx=" + history_detail_idx + ", history_idx=" + history_idx + ", table_name=" + table_name + ", table_column_count=" + table_column_count + ", table_record_count=" + table_record_count
			+ ", execute_result=" + execute_result + "]";
	}

	public void fromMap(Map map) {
		setHistory_detail_idx(getSimpleIntegerProperty(map, "HISTORY_DETAIL_IDX"));
		setHistory_idx(getSimpleIntegerProperty(map, "HISTORY_IDX"));
		setTable_name(getSimpleStringProperty(map, "TABLE_NAME"));
		setTable_column_count(getSimpleIntegerProperty(map, "TABLE_COLUMN_COUNT"));
		setTable_record_count(getSimpleIntegerProperty(map, "TABLE_RECORD_COUNT"));
		setExecute_result(getSimpleStringProperty(map, "EXECUTE_RESULT"));
	}

	private SimpleIntegerProperty getSimpleIntegerProperty(Map map, String key) {
		Object valueObject = map.get(key);
		SimpleIntegerProperty value = new SimpleIntegerProperty(Integer.parseInt(valueObject.toString()));
		return value;
	}

	private SimpleStringProperty getSimpleStringProperty(Map map, String key) {
		Object valueObject = map.get(key);
		SimpleStringProperty value = new SimpleStringProperty(valueObject.toString());
		return value;
	}

}