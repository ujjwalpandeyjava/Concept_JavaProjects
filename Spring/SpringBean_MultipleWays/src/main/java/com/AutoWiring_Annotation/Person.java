package com.AutoWiring_Annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("per")
//@Scope("prototype")	//Create new object every time 
public class Person {
	public Person() {
		super();
	}
	@Value("Ujjwal pandey")
	private String name;
	@Value("#{listPit}")
	private List<String> lit;
	@Autowired
	private Address add;
	@Autowired
	private Education edu;

	public List<String> getLit() {
		return lit;
	}
	public void setLit(List<String> lit) {
		this.lit = lit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	public Education getEdu() {
		return edu;
	}
	public void setEdu(Education edu) {
		this.edu = edu;
	}
	@Override
	public String toString() {
		return "Person [\n name=" + name + ",\n add=" + add + ",\n edu=" + edu
				+ ",\n lit=" + lit + "\n]";
	}
}