package pandey.ujjwal.concepts.dbExample.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	static Connection con;

	public static Connection createConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
		return con;
	}
}
