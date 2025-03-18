package com.spring_jdbc_dao_noXml.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.spring_jdbc_dao_noXml.JavaConfig;
import com.spring_jdbc_dao_noXml.entities.Student;

public class ImplementedRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Student s = (Student) context.getBean("stuObj");
		s.setID(rs.getInt(1));
		s.setName(rs.getString(2));
		s.setClas(rs.getString(3));
		s.setSection(rs.getString(4));
		context.close();
		return s;
	}
}