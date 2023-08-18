package com.spring_orm.dao;

import java.util.List;

import com.spring_orm.model.Student;

public interface DaoInterface {
	public boolean insert(Student s);
	public Student readOne(int id);
	public List<Student> stuList();
	public boolean delete(int id);
	public void update(Student s);
}
