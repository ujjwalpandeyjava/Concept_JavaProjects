package Arrays;

import java.util.ArrayList;

class ArrayListExample {

	public static void main(String args[]) {
		ArrayList<String> color = new ArrayList<String>();
		color.add("Red");
		color.add("Pink");
		color.add("Black");
		color.add("Purple");
		System.out.println("Initial: " + color);
		color.remove("Purple");
		System.out.println("Final: " + color);
	}
}
