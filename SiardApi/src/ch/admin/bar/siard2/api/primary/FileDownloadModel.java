package ch.admin.bar.siard2.api.primary;

import java.util.List;

public class FileDownloadModel {

		private boolean sftpFlag;
		private boolean fileCopyFlag;

		private String host;
		private String user;
		private String password;
		private int port;

		private String sourceFile;
		private String targetFile;
		private String sourceFilePath;
		private String targetFilePath;

		private String schemaName;
		private String tableName;
		private String columnType;
		private String columnName;

		private List<String> chooseColumnList;

		public FileDownloadModel() {

		}

		public boolean isSftpFlag()
		{
			return sftpFlag;
		}

		public void setSftpFlag(boolean sftpFlag)
		{
			this.sftpFlag = sftpFlag;
		}

		public boolean isFileCopyFlag()
		{
			return fileCopyFlag;
		}

		public void setFileCopyFlag(boolean fileCopyFlag)
		{
			this.fileCopyFlag = fileCopyFlag;
		}

		public String getHost()
		{
			return host;
		}

		public void setHost(String host)
		{
			this.host = host;
		}

		public String getUser()
		{
			return user;
		}

		public void setUser(String user)
		{
			this.user = user;
		}

		public String getPassword()
		{
			return password;
		}

		public void setPassword(String password)
		{
			this.password = password;
		}

		public int getPort()
		{
			return port;
		}

		public void setPort(int port)
		{
			this.port = port;
		}

		public String getSourceFile()
		{
			return sourceFile;
		}

		public void setSourceFile(String sourceFile)
		{
			this.sourceFile = sourceFile;
		}

		public String getTargetFile()
		{
			return targetFile;
		}

		public void setTargetFile(String targetFile)
		{
			this.targetFile = targetFile;
		}

		public String getSourceFilePath()
		{
			return sourceFilePath;
		}

		public void setSourceFilePath(String sourceFilePath)
		{
			this.sourceFilePath = sourceFilePath;
		}

		public String getTargetFilePath()
		{
			return targetFilePath;
		}

		public void setTargetFilePath(String targetFilePath)
		{
			this.targetFilePath = targetFilePath;
		}

		public String getSchemaName()
		{
			return schemaName;
		}

		public void setSchemaName(String schemaName)
		{
			this.schemaName = schemaName;
		}

		public String getTableName()
		{
			return tableName;
		}

		public void setTableName(String tableName)
		{
			this.tableName = tableName;
		}

		public String getColumnType()
		{
			return columnType;
		}

		public void setColumnType(String columnType)
		{
			this.columnType = columnType;
		}

		public String getColumnName()
		{
			return columnName;
		}

		public void setColumnName(String columnName)
		{
			this.columnName = columnName;
		}

		public List<String> getChooseColumnList()
		{
			return chooseColumnList;
		}

		public void setChooseColumnList(List<String> chooseColumnList)
		{
			this.chooseColumnList = chooseColumnList;
		}

		@Override
		public String toString() {
			return "FileDownloadModel [sftpFlag=" + sftpFlag + ", fileCopyFlag=" + fileCopyFlag + ", host=" + host + ", user=" + user + ", password=" + password + ", port=" + port + ", sourceFile=" + sourceFile + ", targetFile=" + targetFile
				+ ", sourceFilePath=" + sourceFilePath + ", targetFilePath=" + targetFilePath + ", schemaName=" + schemaName + ", tableName=" + tableName + ", columnType=" + columnType + ", columnName=" + columnName + ", chooseColumnList="
				+ chooseColumnList + "]";
		}


}
