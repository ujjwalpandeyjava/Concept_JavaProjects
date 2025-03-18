package com.Constructor_Injection;

import java.util.List;

public class Person implements InterGuy {
	private int id;
	private String name;
	private Certi cert;
	private List<Double> lis;

	public Person(int id, String name, Certi cert, List<Double> lis) {
		super();
		this.id = id;
		this.name = name;
		this.cert = cert;
		this.lis = lis;
	}

	@Override
	public String toString() {
		return "Person Detail:\nid=" + id + ", name=" + name
				+ ", list values are: " + lis + ", cert=" + cert;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Certi getCert() {
		return cert;
	}

	public List<Double> getLis() {
		return lis;
	}

	public void collegeDetails() {
		System.out.println(colName);
		System.out.println("From person College is enjoyable place." );
		
	}
}