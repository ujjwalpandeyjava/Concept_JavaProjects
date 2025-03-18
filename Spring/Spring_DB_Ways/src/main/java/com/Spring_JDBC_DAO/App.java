package com.Spring_JDBC_DAO;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Spring_JDBC_DAO.dao.DBWork;
import com.Spring_JDBC_DAO.dao.StudentInterface;
import com.Spring_JDBC_DAO.entities.Student;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/Spring_JDBC_DAO/springJDBCdao.xml");

		StudentInterface s = context.getBean("dbwork", DBWork.class);
		// Insert jdbc query
		// Student studentObj = context.getBean("stuObj", Student.class);
		// int insertResult = s.insert(studentObj);
		// System.out.println(insertResult > 0
		// ? "Data inserted successfuly"
		// : "Error in insertion");
		//

		// Update Spring jdbc query
		// int update = s.update();
		// System.out.println("Number of data updated: " +update);

		// Delete spring jdbc query
		// Boolean deleteResult = s.delete();
		// System.out.println("Data deleted: " +deleteResult);

		// View specific data
		// Student OneStu = s.viewOneStudent();
		// System.out.println(OneStu);

		// View all data
		ArrayList<Student> showAll = s.showAll();
		System.out.println("All data.");
		System.out.println(Arrays.toString(showAll.toArray()));

		((ClassPathXmlApplicationContext) context).close();
	}
}