package com.BeanLifeCycle_Interface;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// The implemented method free us from mentioning info of bean lifeCycle in config file

public class Samosa implements InitializingBean, DisposableBean {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		System.out.println("Setting data, before init is called.");
		this.price = price;
	}

	public Samosa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Samosa [price is=" + price + "]";
	}

	public void initmet() {
		System.out.println("Inside init");
	}

	public void destroymeth() {
		// Destroy is used to destroy/close all the connections and APIs which are
		// providing crucial date
		System.out.println("Inside destroy");
	}

	// It do the work of init method of bean lifecycle
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init method fired. ~~~ I am eating somasa");
	}

	// It do the work of destroy method of bean lifecycle
	public void destroy() throws Exception {
		System.out.println("Destroy method fired. ~~~ I already ate somasa");

	}

}
