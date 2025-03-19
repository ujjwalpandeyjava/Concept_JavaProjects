package pandey.ujjwal.concepts.enums;

public enum SimpleEnum_Color {
	RED, GREEN, BLUE;

	public void display() {
		System.out.println("Color: " + this.name());
	}

	public String toString() {
		return "The computed color is: " + this.name();
	}
}
