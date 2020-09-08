package ch.admin.bar.siard2.gui.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class ColumnModel extends TableModel
{
	public SimpleStringProperty	columnName;
	public SimpleStringProperty	columnType;
	public SimpleStringProperty	sourceFileRootPath;
	public BooleanProperty chooseColumnFlag;

	public ColumnModel(String columnName, String columnType, String sourceFileRootPath, boolean chooseColumnFlag) {
		this.columnName = new SimpleStringProperty(columnName);
		this.columnType = new SimpleStringProperty(columnType);
		this.sourceFileRootPath = new SimpleStringProperty(sourceFileRootPath);
		this.chooseColumnFlag = new SimpleBooleanProperty(chooseColumnFlag);
	}

	public ColumnModel(String schemaName, String tableName, String columnName, String columnType, String sourceFileRootPath, boolean chooseColumnFlag) {
		// super
		setSchemaName(schemaName);
		setTableName(tableName);

		this.columnName = new SimpleStringProperty(columnName);
		this.columnType = new SimpleStringProperty(columnType);
		this.sourceFileRootPath = new SimpleStringProperty(sourceFileRootPath);
		this.chooseColumnFlag = new SimpleBooleanProperty(chooseColumnFlag);
	}

	public String getColumnName() {
		return columnName.get();
	}
	public void setColumnName(SimpleStringProperty columnName) {
		this.columnName = columnName;
	}
	public String getColumnType() {
		return columnType.get();
	}
	public void setColumnType(SimpleStringProperty columnType) {
		this.columnType = columnType;
	}
	public String getSourceFileRootPath() {
		return sourceFileRootPath.get();
	}
	public void setSourceFileRootPath(SimpleStringProperty sourceFileRootPath) {
		this.sourceFileRootPath = sourceFileRootPath;
	}
	public boolean getChooseColumnFlag() {
		return chooseColumnFlag.get();
	}
	public void setChooseColumnFlag(SimpleBooleanProperty chooseColumnFlag) {
		this.chooseColumnFlag = chooseColumnFlag;
	}

	public BooleanProperty getChooseColumnFlagProperty()
	{
		return this.chooseColumnFlag;
	}
	public BooleanProperty chooseColumnFlagProperty()
	{
		return chooseColumnFlag;
	}
	@Override
	public void setCheck(Boolean check)
	{
		this.chooseColumnFlag = new SimpleBooleanProperty(check);
	}
}