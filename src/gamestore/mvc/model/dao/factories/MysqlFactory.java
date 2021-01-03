package gamestore.mvc.model.dao.factories;

import java.sql.Connection;
import java.sql.SQLException;

public class MysqlFactory{
 private static Connection connection;
 private static String url = "127.0.0.1";
 private static String port = "3306";
 private static String database = "gamestore";
 private static String user = "root";
 private static String password = "";

 public static Connection getConnection() throws SQLException {
	 if(connection == null) {
		 connection = (Connection) java.sql.DriverManager
					.getConnection("jdbc:mysql://"+ url + ":" + port + "/" + database, user, password);
	 }
	 return connection;
 }

}
