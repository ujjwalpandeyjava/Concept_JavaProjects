package com.Collection_Injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Emp {
	private String name;
	private List<String> phones;
	private Set<String> addresses;
	private Map<String, String> courses;
	private Properties prop;

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public Set<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<String> addresses) {
		this.addresses = addresses;
	}

	public Map<String, String> getCourses() {
		return courses;
	}

	public void setCourses(Map<String, String> courses) {
		this.courses = courses;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(String name, List<String> phones, Set<String> addresses, Map<String, String> courses, Properties prop) {
		super();
		this.name = name;
		this.phones = phones;
		this.addresses = addresses;
		this.courses = courses;
		this.prop = prop;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ",\n phones=" + phones + ",\n addresses=" + addresses + ",\n courses=" + courses
				+ ",\n prop=" + prop + "]";
	}

}
