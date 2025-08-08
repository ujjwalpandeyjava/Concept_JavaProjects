package pandey.ujjwal.concepts.AIWorking;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		// // merger and srot arr list
		// List<Integer> arr1 = new LinkedList<Integer>();
		// arr1.add(1);
		// arr1.add(2);
		// arr1.add(6);
		// arr1.add(11);
		// List<Integer> arr2 = new LinkedList<Integer>();
		// arr2.add(2);
		// arr2.add(3);
		// arr2.add(21);

		// arr1.addAll(arr2);
		// arr1.stream().distinct().sorted((a, b) -> a - b).collect(Collectors.toList())
		// .forEach(e -> {
		// System.out.println(e);
		// });

		// List of products,
		List<Product> parr = new LinkedList<>();
		parr.add(new Product("Laptop", 100));
		parr.add(new Product("Table", 200));
		parr.add(new Product("Mobile Phone", 300));

	}

}

class Product {
	private String name;
	private int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

}

class Product2 {
	private String name;
	private int price;

	private Product2 instane =null;

	private Product2() {
	}
	public getInstance (){
		if(instane == null) {
			
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

}