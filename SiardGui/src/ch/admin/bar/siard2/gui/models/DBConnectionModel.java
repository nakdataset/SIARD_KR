package ch.admin.bar.siard2.gui.models;

public class DBConnectionModel {
	private String connectionUrl;
	private String user;
	private String password;


	DBConnectionModel(){

	}

	public DBConnectionModel(String connectionUrl, String user, String password) {
		super();
		this.connectionUrl = connectionUrl;
		this.user = user;
		this.password = password;
	}

	public String getConnectionUrl() {
		return connectionUrl;
	}
	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}