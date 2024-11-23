package com.Constructor_Injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun {

	// To take care of ambiguity use 'type' and 'index' attribute in
	// 'contructor-agr' tag.
	// Index will work with the nth argument of a constructor.

	/*
	 * In constructor injection it goes to string if no string constructor found
	 * then finds other type of argument constuctor
	 */

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext(
					"com/Constructor_Injection/ConstructorInjection.xml");
			Person p = (Person) context.getBean("per");
			// Here no assign to interface type as we use getters and setters

			System.out.println(
					"Dependency Injection using Constructor, the " + p);
			System.out.println("\nThese from person class Id: " + p.getId()
					+ ", name: " + p.getName()
					+ "\nFrom Referenced Certi class: certi-name: "
					+ p.getCert().getCertiName() + ", Certi-name2: "
					+ p.getCert().getCertiName2());
			// This is from inteface.
			p.collegeDetails();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (context != null)
				((ClassPathXmlApplicationContext) context).close();
		}

	}

}
