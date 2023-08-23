package map;

//HashMap Example
import java.util.Map;
import java.util.HashMap;

class HashMapExample {
	public static void main(String args[]) {
		Map<Integer, String> itis = new HashMap<Integer, String>();// Can also use Map on the place oh HashMap.
		itis.put(1, "one");
		itis.put(2, "Two");
		itis.put(3, "Three");

		System.out.println(itis.get(3));
	}
}