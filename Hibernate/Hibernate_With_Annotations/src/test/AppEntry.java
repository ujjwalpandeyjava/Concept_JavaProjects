package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Employee;

public class AppEntry {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessFact = cfg.buildSessionFactory();
		Session sess = sessFact.openSession();
		Employee obj1 = new Employee("Ujjwal 1", "IT", "CEO", 5000000);
		Employee obj2 = new Employee("Suraj 1", "Sports", "Batsman", 90000);
		sess.beginTransaction(); // No need to first create and then commit transaction
		sess.persist(obj1);
		sess.persist(obj2);
		sess.getTransaction().commit();
	}
}
