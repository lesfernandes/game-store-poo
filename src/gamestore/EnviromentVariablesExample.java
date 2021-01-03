package gamestore;

public class EnviromentVariablesExample {
	private static String url = "127.0.0.1";
	private static String port = "3306";
	private static String database = "gamestore";
	private static String user = "root";
	private static String password = "";

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
