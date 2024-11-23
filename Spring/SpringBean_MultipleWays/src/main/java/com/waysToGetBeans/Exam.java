package com.waysToGetBeans;

public class Exam {

	private String subjectName;
	private String subjectType;

	// Constructors
	public Exam(String subjectName, String sujbectType) {
		super();
		this.subjectName = subjectName;
		this.subjectType = sujbectType;
	}

	public Exam() {
		super();
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	@Override
	public String toString() {
		return "Exam [subjectName=" + subjectName + ", subjectType=" + subjectType + "]";
	}
}