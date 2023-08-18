package com.Spring_JDBC_DAO.dao;

import java.util.ArrayList;

import com.Spring_JDBC_DAO.entities.Student;

public interface StudentInterface {
	public int insert(Student s);
	public int update();
	public Boolean delete();
	public Student viewOneStudent();
	public ArrayList<Student> showAll();
}
