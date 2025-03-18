package com.SpringWork.springorm_try3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringWork.springorm_try3.dao.DaoInterface;
import com.SpringWork.springorm_try3.model.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World! this is spring orm");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringOrmConfig.xml");
		// These lines are for a normal hibernate project
		/*
		 * SessionFactory bean = (SessionFactory) context
		 * .getBean("mySessionFactory"); Session openSession2 =
		 * bean.openSession(); Transaction beginTransaction2 =
		 * openSession2.beginTransaction(); Student s = new Student();
		 * s.setAdd("Address"); s.setDoj(new Date()); s.setName("This is name");
		 * openSession2.save(s); beginTransaction2.commit();
		 * openSession2.close();
		 */

		// For Normal Hibernate with Dependency injection
		/*
		 * SessionFactory bean =
		 * context.getBean("mySessionFactory",SessionFactory.class); Session
		 * currentSession = bean.openSession(); Transaction tr =
		 * currentSession.beginTransaction(); Student s =
		 * context.getBean("StuBean",Student.class); currentSession.save(s);
		 * tr.commit(); currentSession.close(); bean.close();
		 */

		// Best approach
		// Save data
		/*DaoInterface daoBean = (DaoInterface) context.getBean("daooObj");
		Student studentBean = context.getBean("StuBean", Student.class);
		studentBean.setName("jaadu gr2");
		studentBean.setAddre("Sangam vihar2");
		System.out.println(studentBean);
		boolean insertSucces = daoBean.insert(studentBean);
		if (insertSucces)
			System.out.println("Insert successful");
		else
			System.out.println("Error occured while inserting!1");*/

		// Read one data
		/*DaoInterface daoBean = (DaoInterface) context.getBean("daooObj");
		Student readOne = daoBean.readOne(3);
		if(readOne!=null)System.out.println(readOne);
		else System.out.println("Invalid input, this use does not exists.");*/

		//Read multiple data
		/*DaoInterface daoBean = (DaoInterface) context.getBean("daooObj");
		List<Student> stuList = daoBean.stuList();
		for (Student student : stuList) {
			System.out.println(student);
		}*/
		
		//Delete data
		/*DaoInterface daoBean = (DaoInterface) context.getBean("daooObj");
		daoBean.delete(17);*/
		
		//Update data
		DaoInterface daoBean = (DaoInterface) context.getBean("daooObj");
		Student stuUpdate = context.getBean("StuBean", Student.class);
		Student readOne = daoBean.readOne(16);
		stuUpdate.setId(16);
		stuUpdate.setName("Ronny 2");
		stuUpdate.setDoj(readOne.getDoj());
		stuUpdate.setAddre("at molanaa jii house");
		daoBean.update(stuUpdate);
		
		((ClassPathXmlApplicationContext) context).close();
	}
}