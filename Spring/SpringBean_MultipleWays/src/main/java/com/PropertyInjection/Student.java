package com.PropertyInjection;

public class Student implements SuperStudent {

	private int stuId;
	private String stuName;
	private String stuBatch;

	public Student() {
		super();
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuBatch() {
		return stuBatch;
	}

	public void setStuBatch(String stuBatch) {
		this.stuBatch = stuBatch;
	}

	public Student(int stuId, String stuName, String stuClass) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuBatch = stuClass;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName
				+ ", stuBatch=" + stuBatch + "]";
	}

	public void working() {
		System.out.println(
				"Student is working towards becoming a super student.");
	}

}
