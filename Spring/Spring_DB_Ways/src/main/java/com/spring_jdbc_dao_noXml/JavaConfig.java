package com.spring_jdbc_dao_noXml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring_jdbc_dao_noXml.dao.DBWork;
import com.spring_jdbc_dao_noXml.entities.Student;

@Configuration
public class JavaConfig {
	@Bean("stuObj")
	public Student getStudent() {
		Student stu = new Student("pandey", "t", "c");
		stu.setID(5);
		return stu;
	}
	@Bean
	public DriverManagerDataSource getDMDS() {
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dm.setUrl("jdbc:mysql://localhost:3306/springDB");
		dm.setUsername("root");
		dm.setPassword("Goldenstar@1234");
		return dm;
	}
	@Bean
	public JdbcTemplate getTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDMDS());
		return template;
	}
	@Bean("getdbwork")
	public DBWork getDbWork() {
		DBWork dbw = new DBWork();
		dbw.setTemplate(getTemplate());
		return dbw;
	}

}
