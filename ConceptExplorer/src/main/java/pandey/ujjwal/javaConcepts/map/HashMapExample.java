package pandey.ujjwal.javaConcepts.map;

//HashMap Example
import java.util.Map;
import java.util.HashMap;

class HashMapExample {
	public static void main(String args[]) {
		Map<Integer, String> itis = new HashMap<Integer, String>();// Can also use Map on the place oh HashMap.
		itis.put(1, "one");
		itis.put(2, "Two");
		itis.put(3, "Three");
		System.out.println(itis);
		System.out.println(itis.get(3));
		
		Map<String, Object> mapA = Map.of(
		    "path", "path",
		    "method", "method",
		    "error_message", "error_message"
		);
		Map<String, Object> mapB = new HashMap<String, Object>() {{
		    put("path", "path");
		    put("method", "method");
		    put("error_message", "error_message");
		}};

		System.out.println(mapA);
		System.out.println(mapB);
	}
}