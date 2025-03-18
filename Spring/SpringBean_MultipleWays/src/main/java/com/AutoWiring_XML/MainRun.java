package com.AutoWiring_XML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/AutoWiring_XML/AutoConfig.xml");
		Emp e = context.getBean("emp1", Emp.class);
		System.out.println(e);
		((ClassPathXmlApplicationContext) context).close();
	}

}
