package com.Collection_Injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun {

	public static void main(String[] args) {
		System.out.println("DI for Collections");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/Collection_Injection/propertyInjectionCollections.xml");
		// When the configuration file is in same folder.
		// The default folder is sr/main/java
		Emp e = (Emp) context.getBean("GetEmpBean");
		System.out.println(e);
		((ClassPathXmlApplicationContext) context).close();
	}

}
