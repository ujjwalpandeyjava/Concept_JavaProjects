package com.BeanLifeCycle_XML;

public class Samosa {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		System.out.println("Date set, before init is called.");
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

}
