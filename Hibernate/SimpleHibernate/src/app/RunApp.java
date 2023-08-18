package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunApp {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("./hibernate.cfg.xml");
		SessionFactory sessFact = cfg.buildSessionFactory();
		Session sess = sessFact.openSession();

		Book boo = new Book("Atomic Habits", 350);

		Comic comi = new Comic();
		comi.setName("Ultiamte Spiderman vol-455");
		comi.setPrice(150);
		comi.setAuthName("Team marvels");

		Literature lit = new Literature();
		lit.setName("Mangroove");
		lit.setPrice(800);
		lit.setAuthName("Team 7");

		sess.beginTransaction();
		sess.persist(boo);
		sess.persist(comi);
		sess.persist(lit);

		sess.getTransaction().commit();
		System.out.println("Saved!!");
	}

}
