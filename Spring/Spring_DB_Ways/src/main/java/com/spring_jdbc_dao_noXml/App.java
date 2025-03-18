package com.spring_jdbc_dao_noXml;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_jdbc_dao_noXml.dao.DBWork;
import com.spring_jdbc_dao_noXml.dao.StudentInterface;
import com.spring_jdbc_dao_noXml.entities.Student;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				JavaConfig.class);

		StudentInterface s = context.getBean("getdbwork", DBWork.class);
		// Insert jdbc query
//		Student studentObj = context.getBean("stuObj", Student.class);
//		int insertResult = s.insert(studentObj);
//		System.out.println(insertResult > 0
//				? "Data inserted successfuly"
//				: "Error in insertion");

		// Update Spring jdbc query
//		 int update = s.update();
//		 System.out.println("Number of data updated: " +update);

		// Delete spring jdbc query
//		 Boolean deleteResult = s.delete();
//		 System.out.println("Data deleted: " +deleteResult);

		// View specific data
//		 Student OneStu = s.viewOneStudent();
//		 System.out.println(OneStu);

		// View all data
		 ArrayList<Student> showAll = s.showAll();
		 System.out.println("All data.");
		 for (Student string : showAll) {
		 System.out.println(string);
		 }

		((AnnotationConfigApplicationContext) context).close();
	}

}
