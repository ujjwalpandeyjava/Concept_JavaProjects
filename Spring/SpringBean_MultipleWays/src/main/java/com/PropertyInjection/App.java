package com.PropertyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		System.out.println("Property Injection demo!!");
		/*
		 * // BeanFactory do same work as applicationContext. //
		 * ApplicationContext is superset of BeanFactory // BeanFactory for
		 * small applications and ApplicationContext for large // scale apps
		 * BeanFactory contr = new ClassPathXmlApplicationContext(
		 * "PropertyInjection.xml");
		 */
		ApplicationContext cont = new ClassPathXmlApplicationContext(
				"PropertyInjection.xml");
		Student s1 = (Student) cont.getBean("way1");
		Student s2 = (Student) cont.getBean("way2");
		Student se = cont.getBean("gs", GirlStudent.class);
		SuperStudent s3 = (Student) cont.getBean("way3");
		/*
		 * Use interfaces so that whenever we want to change the object type we
		 * don't have to change the Type of object
		 */

		System.out.println("Way one1: " + s1);
		System.out.println("Way one1: " + s2);
		System.out.println("Way one1: " + s3 + ", and ");
		s3.working();
		se.working();
		System.out.println(se.getStuBatch());
		((ClassPathXmlApplicationContext) cont).close();
	}

}
