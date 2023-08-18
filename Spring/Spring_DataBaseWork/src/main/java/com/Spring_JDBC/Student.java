package com.Spring_JDBC;

public class Student {
	private int ID;
	private String name;
	private String clas;
	private String section;

	public Student() {
	}

	public Student(int iD, String name, String clas, String section) {
		super();
		this.ID = iD;
		this.name = name;
		this.clas = clas;
		this.section = section;
	}

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
		return "Student [ID=" + ID + ", name=" + name + ", clas=" + clas + ", section=" + section + "]";
	}
}