package com.Reference_Type_OR_MethodInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun {

//	This one is fully exception handled code of DI
	
	public static void main(String[] args) {
		System.out.println("Dependencies Injection For Reference Type.");
		ApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("com/Reference_Type_OR_MethodInjection/reference_Type_Config.xml");
			A d = (A) context.getBean("aRef2");
			System.out.println("Id of A: " + d.getaId() + "\nId of B (from A): " + d.getbObj().getbId());
			System.out.println(d);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (context != null)
				((ClassPathXmlApplicationContext) context).close();

		}
	}

}
