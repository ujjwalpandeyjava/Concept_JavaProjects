package com.waysToGetBeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Must use "@Component" annotation to tell it is a bean
@Component("getStudent")
public class Student {
	@Value("Ujjwal pandey jii")
	private String name;

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	void study() {
		System.out.println("Method study() called...");
	}

	public Student() {
		super();
	}

}
