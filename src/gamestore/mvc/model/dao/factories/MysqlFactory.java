package gamestore.mvc.model.dao.factories;

import java.sql.Connection;
import java.sql.SQLException;

import gamestore.EnviromentVariables;

public class MysqlFactory{
 private static Connection connection;
 private static String url = EnviromentVariables.getUrl();
 private static String port = EnviromentVariables.getPort();
 private static String database = EnviromentVariables.getDatabase();
 private static String user = EnviromentVariables.getUser();
 private static String password = EnviromentVariables.getPassword();
	
 public static Connection getConnection() throws SQLException {
	 
	 if(connection == null) {
		 connection = (Connection) java.sql.DriverManager
					.getConnection("jdbc:mysql://"+ url + ":" + port + "/" + database, user, password);
	 }
	 return connection;
 }
 
}
