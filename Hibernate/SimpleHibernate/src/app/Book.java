package app;

public class Book {
	int bookID;
	String name;
	int price;

	int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Book() {
		super();
	}

	public Book(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
}