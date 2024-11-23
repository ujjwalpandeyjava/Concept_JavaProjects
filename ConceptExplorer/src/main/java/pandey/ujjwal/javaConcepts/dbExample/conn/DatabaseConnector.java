package pandey.ujjwal.javaConcepts.dbExample.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	private static final String URL = "jdbc:mysql://localhost:3306/mail_system";
	private static final String USER = "root";
	private static final String PASSWORD = "Goldenstar@123";
	private static Connection connection;

	// Private constructor to restrict instantiation
	private DatabaseConnector() {
	}

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	public static void destroyConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connection = null;
			}
		}
	}
}
