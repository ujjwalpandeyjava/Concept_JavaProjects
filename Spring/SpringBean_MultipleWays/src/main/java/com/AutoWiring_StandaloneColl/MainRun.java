package com.AutoWiring_StandaloneColl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun {
	public static void main(String[] args) {
		System.out.println("Auto Wiring using annotations.");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/AutoWiring_StandaloneColl/AutoConfigAnnot.xml");
		Person p = context.getBean("per", Person.class);
		System.out.println(p);
		System.out.println(p.getLit().getClass());

		if (context != null)
			((ClassPathXmlApplicationContext) context).close();
	}
}
