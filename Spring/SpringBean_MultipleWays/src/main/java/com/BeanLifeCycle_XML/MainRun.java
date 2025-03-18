package com.BeanLifeCycle_XML;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun {

	public static void main(String[] args) {
		
		System.out.println("Bean life cycle is maintained in the Bean itself and called using xml config");
		
		// Can use any 'AbstractApplicationContext' or 'ApplicationContext'
		AbstractApplicationContext context = null;
		try {

			context = new ClassPathXmlApplicationContext("com/BeanLifeCycle_XML/SomasaConfig.xml");
			Samosa s = (Samosa) context.getBean("s1");
			System.out.println(s);
			
			// This one is to tell that call destroy method of bean lifeCycle.
				context.registerShutdownHook();
			//It can't be done with 'ApplicationContext' it need 'AbstractApplicationContext'.
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (context != null)
				((ClassPathXmlApplicationContext) context).close();
			
			// Closing the spring configuration.xml so that no unknown can use it.
		
		}
	}

}
