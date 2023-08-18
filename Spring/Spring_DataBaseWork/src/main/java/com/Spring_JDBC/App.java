package com.Spring_JDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

//*Instead of doing this
// Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
// Statement stmt = conn.createStatement();
// ResultSet rs = stmt.executeQuery(QUERY);
// * We use SpringsFrameworks JDBCTemplate with DI
public class App {
	public static void main(String[] args) {

		System.out.println(
				"________________________________________________________________________________________________________");
		System.out.println("\nTheory for Spring_JDBC");
		System.out.println("The spring jdbc is like using jdbc in an normal java app, difference is we are using spring"
				+ " (Injecting objects instead of creating them in classes),"
				+ "\nAnd the springMVC will be like: create an java web app using spring.");
		System.out.println(
				"________________________________________________________________________________________________________");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/Spring_JDBC/springJDBC.xml");
		JdbcTemplate springBean = context.getBean("jdbcTemplate", JdbcTemplate.class);

		/*
		 * // Data to add normal (-Not recommended) String q =
		 * "insert into student(ID, name, clas, section) values(13, 'ujjwal', '5th', 'b')"
		 * ; int updated = springBean.update(q); System.out.println(updated);
		 */

		// Data is user given (-Not recommended)
		String queryStr = "insert into student(ID, name, clas, section) values(?,?,?,?)";
		int updated = springBean.update(queryStr, 10, "suraj", "12th", "a");
		System.out.println(updated);

		// RECCOMANDED WAY - use JDBC-DAO

		System.out.println(updated > 0 ? "Data entered" : "Error occured");
		((ClassPathXmlApplicationContext) context).close();
	}
}