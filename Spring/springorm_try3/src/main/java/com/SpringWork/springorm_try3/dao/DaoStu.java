package com.SpringWork.springorm_try3.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.SpringWork.springorm_try3.model.Student;

public class DaoStu implements DaoInterface {

	private HibernateTemplate hbTem;

	@Override
	@Transactional
	public boolean insert(Student s) {
		int save = (Integer) this.hbTem.save(s);
		// Return the unique id of data entered
		System.out.println(save);
		if (save > 0)
			return true;
		else
			return false;
	}

	@Override
	@Transactional
	public Student readOne(int id) {
		Student student = null;
		try {
			student = this.hbTem.get(Student.class, id);
		} catch (Exception e) {
			System.out.println("Invalid input, this use does not exists.");
		}
		return student;
	}

	@Override
	@Transactional // no need
	public List<Student> stuList() {
		List<Student> loadAll = this.hbTem.loadAll(Student.class);
		return loadAll;
	}

	@Override
	@Transactional
	public boolean delete(int id) {
		Student studentToDelete = this.hbTem.get(Student.class, id);
		this.hbTem.delete(studentToDelete);
		return true;
	}

	@Override
	@Transactional
	public void update(Student s) {
		this.hbTem.update(s);
	}

	/* public HibernateTemplate getHbTem() {
		return hbTem;
	}
	public void setHbTem(HibernateTemplate hbTem) {
		this.hbTem = hbTem;
	}*/
}