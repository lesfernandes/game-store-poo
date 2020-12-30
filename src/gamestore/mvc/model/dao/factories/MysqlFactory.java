package gamestore.mvc.model.dao.factories;

import java.sql.Connection;
import java.sql.SQLException;

public class MysqlFactory{
 private static Connection connection;
 private static String url = "172.17.0.2";
 private static String port = "3306";
 private static String database = "";
 private static String user = "";
 private static String password = "password";
	
 public static Connection getConnection() throws SQLException {
	 if(connection == null) {
		 connection = (Connection) java.sql.DriverManager
					.getConnection("jdbc:mysql://"+ url + "/" + port + "/" + database, user, password);
	 }
	 return connection;
 }
 
}
