package ch.admin.bar.siard2.gui.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableModel extends DBConnectionModel{
	private SimpleStringProperty	schemaName;
	private SimpleStringProperty	tableName;
	private BooleanProperty chooseTableFlag;

	public TableModel() {
	}

	public TableModel(String schemaName, String tableName, boolean chooseTableFlag) {
		this.schemaName = new SimpleStringProperty(schemaName);
		this.tableName = new SimpleStringProperty(tableName);
		this.chooseTableFlag = new SimpleBooleanProperty(chooseTableFlag);
	}

	public String getSchemaName() {
		return schemaName.get();
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = new SimpleStringProperty(schemaName);
	}
	public String getTableName() {
		return tableName.get();
	}
	public void setTableName(String tableName) {
		this.tableName = new SimpleStringProperty(tableName);
	}
	public boolean getChooseTableFlag() {
		return chooseTableFlag.get();
	}
	public void setChooseTableFlag(SimpleBooleanProperty chooseTableFlag) {
		this.chooseTableFlag = chooseTableFlag;
	}

	public BooleanProperty getChooseTableFlagProperty()
	{
		return this.chooseTableFlag;
	}
	public BooleanProperty chooseTableFlagProperty()
	{
		return chooseTableFlag;
	}
	public void setCheck(Boolean check)
	{
		this.chooseTableFlag = new SimpleBooleanProperty(check);
	}
}