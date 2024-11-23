package com.BeanLifeCycle_Interface;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun {

	public static void main(String[] args) {
		System.out.println("Working in life cycle with Interfaces.\n");
		AbstractApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("com/BeanLifeCycle_Interface/SomasaConfig.xml");
			Samosa sam = (Samosa) context.getBean("s1");
			System.out.println(sam);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (context != null)
				((ClassPathXmlApplicationContext) context).close();
			//context.registerShutdownHook();
		}

	}

}
