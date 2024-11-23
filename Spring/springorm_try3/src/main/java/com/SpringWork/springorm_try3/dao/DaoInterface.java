package com.SpringWork.springorm_try3.dao;

import java.util.List;

import com.SpringWork.springorm_try3.model.Student;

public interface DaoInterface {
	public boolean insert(Student s);

	public Student readOne(int id);

	public List<Student> stuList();

	public boolean delete(int id);

	public void update(Student s);
}
