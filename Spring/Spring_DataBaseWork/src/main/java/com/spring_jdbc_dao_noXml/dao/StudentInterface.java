package com.spring_jdbc_dao_noXml.dao;

import java.util.ArrayList;

import com.spring_jdbc_dao_noXml.entities.Student;

public interface StudentInterface {
	public int insert(Student s);
	public int update();
	public Boolean delete();
	public Student viewOneStudent();
	public ArrayList<Student> showAll();
}
