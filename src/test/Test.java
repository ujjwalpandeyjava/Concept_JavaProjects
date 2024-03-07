package test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Student;

public class Test {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessFect = cfg.buildSessionFactory();
		Session sess = sessFect.openSession();

		// Write begin here
		Transaction tr = sess.beginTransaction();

		Student obj = new Student();
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter name:-");
		obj.setName(scn.nextLine());
		System.out.print("Enter Course name:- ");
		String courseName = scn.nextLine();
		obj.setCourse(courseName);
		System.out.print("Enter the fee of " + courseName + ":-");
		obj.setFee(scn.nextInt());
		System.out.println(obj);

//		Student obj = new Student();
//		obj.setName("Ujjwal 1");
//		obj.setCourse("Java 1");
//		obj.setFee(12000);
//		System.out.println(obj);

		sess.persist(obj);
		tr.commit();
		scn.close();

		System.out.println("Object presisted and data entered...");
		Query query = sess.createQuery("from Student");
//		@SuppressWarnings("unchecked")
		List<Student> results = query.list();
		System.out.println(results);
	}

}
