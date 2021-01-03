package gamestore;

public class EnviromentVariablesExample {
	private static String url = "172.17.0.2";
	private static String port = "3306";
	private static String database = "gamestore";
	private static String user = "root";
	private static String password = "password";
	
	public static String getUrl() {
		return url;
	}
	public static String getPort() {
		return port;
	}
	public static String getDatabase() {
		return database;
	}
	public static String getUser() {
		return user;
	}
	public static String getPassword() {
		return password;
	}
}
