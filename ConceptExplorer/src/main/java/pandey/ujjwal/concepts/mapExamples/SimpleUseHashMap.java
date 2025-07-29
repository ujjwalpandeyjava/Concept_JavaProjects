package pandey.ujjwal.concepts.mapExamples;

import java.util.HashMap;
import java.util.Map;

class SimpleUseHashMap {
	public static void main(String ass[]) {
		Map<String, String> mapObj = new HashMap<>();
		// here strung1=key,string2= value.
		// key is - the word which we enter to get the value.
		// It will get all the key and then show the values.
		mapObj.put("monday", "table 1");
		mapObj.put("tuesday", "table 2");
		mapObj.put("wednesday", "table 3");
		mapObj.put("thursday", "table 4");
		mapObj.put("friday", "table 5");
		mapObj.put("saturday", "table 6");
		mapObj.put("sunday", "table 7");

		// get the value stored on the key...
		System.out.println("Monday: " + mapObj.get("Monday") + " > not available!"); // Key is caseSensitive
		System.out.println(mapObj.get("monday"));
		System.out.println(mapObj.get("tuesday"));
		System.out.println(mapObj.get("wednesday"));
		System.out.println(mapObj.get("thursday"));
		System.out.println(mapObj.get("friday"));
		System.out.println(mapObj.get("saturday"));
		System.out.println(mapObj.get("sunday"));
		// print out all keys.
		System.out.println(mapObj.keySet());
		// print our all values.
		System.out.println(mapObj.values());
		// print out size.
		System.out.println("size of the dictionary : " + mapObj.size());

		System.out.println("\n\nMap with Wrapper class");
		Map<Integer, String> mapIntString = new HashMap<Integer, String>();// Can also use Map on the place oh HashMap.
		mapIntString.put(1, "one");
		mapIntString.put(2, "Two");
		mapIntString.put(3, "Three");
		System.out.println(mapIntString);
		System.out.println(mapIntString.get(3));

		// Shortcuts
		Map<String, Object> mapA = Map.of(
				"path", "path",
				"method", "method",
				"error_message", "error_message");
		Map<String, Object> mapB = new HashMap<String, Object>() {
			{
				put("path", "path");
				put("method", "method");
				put("error_message", "error_message");
			}
		};

		System.out.println(mapA);
		System.out.println(mapB);
	}
}