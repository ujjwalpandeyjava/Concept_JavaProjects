package com.waysToGetBeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun {
	// Simple app not a WebApp
	public static void main(String[] args) {
//		AbstractApplicationContext forXMLBasedConfig  = new ClassPathXmlApplicationContext("com/BeanLifeCycle_Interface/SomasaConfig.xml");	// For XML based configuration.

		/* Way 1: Direct from POJO as bean */
		// For annotation based configuration.
		ApplicationContext context = new AnnotationConfigApplicationContext(Configurations.class);
		Student bean1 = context.getBean("getStudent", Student.class);
		System.out.println(bean1);
		bean1.study();
		((AbstractApplicationContext) context).close();

		/* Way 2: From config file as bean */
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(Configurations.class);
		Study studyObj = context2.getBean("getStudy", Study.class);
		System.out.println(studyObj);
		studyObj.goStudyNow();
		context2.close();

		/* From: From XML file as bean [Constructor, getters] */
		// Can use any 'AbstractApplicationContext' or 'ApplicationContext'
		AbstractApplicationContext contextXML = null;
		try {
			contextXML = new ClassPathXmlApplicationContext("com/waysToGetBeans/beansXML.xml");
			Samosa samosaBean = (Samosa) contextXML.getBean("samosas");
			System.out.println(samosaBean);

			// Tells to call destroy method of bean lifeCycle
			contextXML.registerShutdownHook();
			// Can not be done with 'ApplicationContext' it needs
			// 'AbstractApplicationContext'.

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (contextXML != null)
				((ClassPathXmlApplicationContext) contextXML).close();
			// Closing the spring configuration.xml so that no unknown process/ user can use
			// it
		}
	}
}