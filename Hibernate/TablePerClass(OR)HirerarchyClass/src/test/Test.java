package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Book;
import model.Comic;
import model.Literature;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessFact = cfg.buildSessionFactory();
		Session sess = sessFact.openSession();

		Book boo = new Book();
		boo.setName("Atomic Habits");
		boo.setPrice(350);

		Comic comi = new Comic();
		comi.setName("Ultiamte Spiderman vol-457");
		comi.setPrice(150);
		comi.setAuthName("Team marvels");

		Literature lit = new Literature();
		lit.setName("Mangroovem passti");
		lit.setPrice(800);
		lit.setAuthName("Team 9");

		sess.beginTransaction();
		sess.persist(boo);
		sess.persist(comi);
		sess.persist(lit);

		sess.getTransaction().commit();
		System.out.println("Presisted...");
	}

}
