package dbExample.dao;

import java.util.List;

import dbExample.model.Student;

public interface StudentDao {
  public void create(Student ob) throws Exception;

  public void delete(int id) throws Exception;

  public List<Student> displayAll() throws Exception;

  public Student getStudentById(int id) throws Exception;

  public void update(Student ob) throws Exception;
}
