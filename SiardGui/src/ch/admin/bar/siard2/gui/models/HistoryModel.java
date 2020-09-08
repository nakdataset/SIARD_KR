package ch.admin.bar.siard2.gui.models;

import java.util.Map;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class HistoryModel {

	private SimpleIntegerProperty history_idx;
	private SimpleStringProperty div;
	private SimpleStringProperty db_name;
	private SimpleStringProperty db_con_url;
	private SimpleStringProperty schema_name;
	private SimpleStringProperty table_count;
	private SimpleStringProperty execute_result;
	private SimpleStringProperty execute_date;
	private Button report_print;

	public HistoryModel(){}

	HistoryModel(SimpleIntegerProperty history_idx, SimpleStringProperty div, SimpleStringProperty db_name, SimpleStringProperty db_con_url, SimpleStringProperty schema_name, SimpleStringProperty table_count, SimpleStringProperty execute_result,
		SimpleStringProperty execute_date, Button report_print) {
		super();
		this.history_idx = history_idx;
		this.div = div;
		this.db_name = db_name;
		this.db_con_url = db_con_url;
		this.schema_name = schema_name;
		this.table_count = table_count;
		this.execute_result = execute_result;
		this.execute_date = execute_date;
		this.report_print = report_print;
	}

	public int getHistory_idx() {
		return history_idx.get();
	}


	public void setHistory_idx(SimpleIntegerProperty history_idx) {
		this.history_idx = history_idx;
	}


	public String getDiv() {
		return div.get();
	}


	public void setDiv(SimpleStringProperty div) {
		this.div = div;
	}


	public String getDb_name() {
		return db_name.get();
	}


	public void setDb_name(SimpleStringProperty db_name) {
		this.db_name = db_name;
	}


	public String getDb_con_url() {
		return db_con_url.get();
	}


	public void setDb_con_url(SimpleStringProperty db_con_url) {
		this.db_con_url = db_con_url;
	}


	public String getSchema_name() {
		return schema_name.get();
	}


	public void setSchema_name(SimpleStringProperty schema_name) {
		this.schema_name = schema_name;
	}


	public String getTable_count() {
		return table_count.get();
	}


	public void setTable_count(SimpleStringProperty table_count) {
		this.table_count = table_count;
	}


	public String getExecute_result() {
		return execute_result.get();
	}


	public void setExecute_result(SimpleStringProperty execute_result) {
		this.execute_result = execute_result;
	}


	public String getExecute_date() {
		return execute_date.get();
	}


	public void setExecute_date(SimpleStringProperty execute_date) {
		this.execute_date = execute_date;
	}
	
	public Button getReport_print() {
		return report_print;
	}

	public void setReport_print(Button report_print) {
		this.report_print = report_print;
	}

	@Override
	public String toString() {
		return "HistoryModel [history_idx=" + history_idx + ", div=" + div + ", db_name=" + db_name + ", db_con_url=" + db_con_url + ", schema_name=" + schema_name + ", table_count=" + table_count + ", execute_result=" + execute_result + ", execute_date="
				+ execute_date + ", report_print=" + report_print + "]";
	}

	public void fromMap(Map map) {
		setHistory_idx(getSimpleIntegerProperty(map, "HISTORY_IDX"));
		setDiv(getSimpleStringProperty(map, "DIV"));
		setDb_name(getSimpleStringProperty(map, "DB_NAME"));
		setDb_con_url(getSimpleStringProperty(map, "DB_CON_URL"));
		setSchema_name(getSimpleStringProperty(map, "SCHEMA_NAME"));
		setTable_count(getSimpleStringProperty(map, "TABLE_COUNT"));
		setExecute_result(getSimpleStringProperty(map, "EXECUTE_RESULT"));
		setExecute_date(getSimpleStringProperty(map, "EXECUTE_DATE"));
		setReport_print(getButton(map, "REPORT_PRINT"));
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
	
	private Button getButton(Map map, String key) {
		return (Button) map.get(key);
	}

}