package com.BeanLifeCycle_Annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Samosa {
	private String taste;

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		System.out.println("Date set, before init is called.");
		this.taste = taste;
	}

	public Samosa() {
		super();
	}

	@Override
	public String toString() {
		return "Samosa [taste is= " + taste + "]";
	}

	@PostConstruct
	public void initmet() {
		System.out.println("Inside init");
	}

	@PreDestroy
	public void destroymeth() {
		// Destroy is used to destroy/close all the connections and APIs which are
		// providing crucial date
		System.out.println("Inside destroy");
	}
	/*
	 * To use these two annotations do either one of these 
	 * 1). Use jdk8- OR jdk15+
	 * 2). Use <!--
	 * https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api -->
	 * <dependency> <groupId>javax.annotation</groupId>
	 * <artifactId>javax.annotation-api</artifactId> <version>1.3.2</version>
	 * </dependency> 
	 */

}
