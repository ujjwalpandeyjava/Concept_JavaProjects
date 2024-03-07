package arrayListExample;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		List<Integer> ob = new ArrayList<Integer>();
		ob.add(0, 56);
		ob.add(555);
		ob.add(454545);
		System.out.println("The elements are: " + ob);
		ob.add(1, 48);
		ob.add(47);
		System.out.println("The elements are: " + ob);
		for (Integer i : ob) {
			System.out.println("Value: " + i);
		}
	}
}
