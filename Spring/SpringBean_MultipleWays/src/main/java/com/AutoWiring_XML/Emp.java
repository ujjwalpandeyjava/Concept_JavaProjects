package com.AutoWiring_XML;

public class Emp {
	private String name;
	private Address add;
	
	
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
	
	
	public Emp() {
		super();
	}
	public Emp(String name, Address add) {
		super();
		System.out.println("Inside emp constructor");
		this.name = name;
		this.add = add;
	}
	
	
	@Override
	public String toString() {
		return "Emp [name=" + name + ", add=" + add + "]";
	}

	
}
