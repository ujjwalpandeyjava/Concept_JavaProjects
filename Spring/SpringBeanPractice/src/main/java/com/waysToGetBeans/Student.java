package com.waysToGetBeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Must use "@Component" annotation to tell it is a bean
@Component("getStudent")
@Scope(scopeName = "prototype")	// Singelton so that the whole app does not have same scope.
public class Student {
	@Value("Ujjwal pandey")
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
