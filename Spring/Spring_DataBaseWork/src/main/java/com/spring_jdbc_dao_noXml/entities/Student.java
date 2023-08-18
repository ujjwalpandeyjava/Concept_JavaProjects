package com.spring_jdbc_dao_noXml.entities;

public class Student {

	public Student() {
	}

	private int ID;
	private String name;
	private String clas;
	private String section;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", name=" + name + ", clas=" + clas
				+ ", section=" + section + "]";
	}

	public Student(String name, String clas, String section) {
		super();
		this.name = name;
		this.clas = clas;
		this.section = section;
	}

}