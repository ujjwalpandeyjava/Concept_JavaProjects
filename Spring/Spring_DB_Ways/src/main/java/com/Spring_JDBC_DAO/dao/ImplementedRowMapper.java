package com.Spring_JDBC_DAO.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.Spring_JDBC_DAO.entities.Student;

public class ImplementedRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/Spring_JDBC_DAO/springJDBCdao.xml");
		Student s = (Student) context.getBean("stuObj");
		s.setID(rs.getInt(1));
		s.setName(rs.getString(2));
		s.setClas(rs.getString(3));
		s.setSection(rs.getString(4));
		context.close();
		return s;
	}

}
