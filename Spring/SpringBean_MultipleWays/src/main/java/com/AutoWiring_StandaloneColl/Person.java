package com.AutoWiring_StandaloneColl;

import java.util.List;

public class Person {
	private String name;
	private Address add;
	private Education edu;
	private List<String> lit;

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
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", add=" + add + ", edu=" + edu
				+ ", lit=" + lit + "]";
	}

}
