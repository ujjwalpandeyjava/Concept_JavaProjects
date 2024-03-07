package com.waysToGetBeans;

public class Samosa {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		System.out.println("Data set, before beanInitialized is called.");
		this.price = price;
	}

	public Samosa() {
		super();
	}

	public void beanInitialized() {
		System.out.println("Inside init");
	}

	public void beanDestroyed() {
		// Calls when garbage collector get the obj
		System.out.println("Destry of Samosa called");
	}

	@Override
	public String toString() {
		return "Samosa [price is=" + price + "]";
	}

}
