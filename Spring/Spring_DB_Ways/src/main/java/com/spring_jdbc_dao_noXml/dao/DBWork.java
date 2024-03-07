package com.spring_jdbc_dao_noXml.dao;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring_jdbc_dao_noXml.entities.Student;

public class DBWork implements StudentInterface {

	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	Scanner scn = null;

	@Override
	public int insert(Student s) {
		scn = new Scanner(System.in);
		String q = "insert into student(ID, name, clas, section) values(?,?,?,?)";
		System.out.println("Enter id of student!!");
		int id = Integer.parseInt(scn.nextLine());
		System.out.println("Enter name of student!!");
		String name = scn.nextLine();

		int res = this.template.update(q, id, name, s.getClas(),
				s.getSection());
		scn.close();
		return res;
	}
	@Override
	public int update() {
		scn = new Scanner(System.in);
		String q = "update student set name = ? , section = ? where id = ?";
		System.out.print("Enter id of student to change its details: ");
		int id = Integer.parseInt(scn.nextLine());
		System.out.print("Enter name of student to change: ");
		String name = scn.nextLine();
		System.out.println("Enter section of student: ");
		String cls = scn.nextLine();

		int updateResult = this.template.update(q, name, cls, id);
		scn.close();
		return updateResult;
	}
	@Override
	public Boolean delete() {
		scn = new Scanner(System.in);
		String q = "delete from student where id = ?";
		System.out.print("Enter id of student to delete: ");
		int id = scn.nextInt();
		int updateResult = this.template.update(q, id);
		scn.close();
		if (updateResult > 0)
			return true;
		else
			return false;
	}
	@Override
	public Student viewOneStudent() {
		scn = new Scanner(System.in);
		String q = "SELECT * FROM student WHERE id = ?";
		System.out.print("Enter studet ID to see it details: ");
		int id = scn.nextInt();
		RowMapper<Student> rms = new ImplementedRowMapper();
		Student oneStudent = this.template.queryForObject(q, rms, id);
		scn.close();
		return oneStudent;
	}
	@Override
	public ArrayList<Student> showAll() {
		String q = "SELECT * FROM student";
		RowMapper<Student> rms = new ImplementedRowMapper();
		ArrayList<Student> l = (ArrayList<Student>) this.template.query(q, rms);
		return l;
	}
}