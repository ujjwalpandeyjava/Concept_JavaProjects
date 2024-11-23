package com.AutoWiring_Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppEntry {
	public static void main(String[] args) {

		/*
		 * In this example : Use of @Component, @Value, @Value for collections
		 * and Scope (XML and Annotation)
		 */

		System.out.println("Auto Wiring using annotations.");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/AutoWiring_Annotation/AutoConfigAnnot.xml");
		Person p = context.getBean("per", Person.class);
		System.out.println(p);
		System.out.println(p.getLit().getClass());
		/*
			// Uncomment this block and @scope in person class to see proof of  changed scope with annotation
		 * System.out.println(p.hashCode()); Person p2 = context.getBean("per",
		 * Person.class); Person p3 = context.getBean("per", Person.class);
		 * System.out.println(p2.hashCode()); System.out.println(p3.hashCode());
		 */
		/*//Uncomment to see the ScopeChange using XML
		 * ScopeChange s1 = context.getBean("ScopeChangeByXML",
		 * ScopeChange.class); ScopeChange s2 =
		 * context.getBean("ScopeChangeByXML", ScopeChange.class); ScopeChange
		 * s3 = context.getBean("ScopeChangeByXML", ScopeChange.class);
		 * System.out.println(s1.hashCode()); System.out.println(s2.hashCode());
		 * System.out.println(s3.hashCode());
		 */
		if (context != null)
			((ClassPathXmlApplicationContext) context).close();
	}
}
