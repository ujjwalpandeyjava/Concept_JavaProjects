package map;

import java.util.HashMap;
import java.util.Map;

class DictonaryPractice_Map {
	public static void main(String ass[])
	// public static void main(String []argh)
	{
		Map<String, String> dictonary = new HashMap<>();
		// here strung1=key,string2= value.
		// key is - the word which we enter to get the value.
		// It will get all the key and then show the values.
		dictonary.put("\n\nmonday", "table 1");
		dictonary.put("tuesday", "table 2");
		dictonary.put("wednesday", "table 3");
		dictonary.put("thrusday", "table 4");
		dictonary.put("friday", "table 5");
		dictonary.put("saturday", "table 6");
		dictonary.put("sunday", "table 7");
		// to get the value stored on the key...
		System.out.println(dictonary.get("Monday") + " not avilable..");// Word specific hai
		System.out.println("monday  " + dictonary.get("monday"));
		System.out.println(dictonary.get("tuesday"));
		System.out.println(dictonary.get("wednesday"));
		System.out.println(dictonary.get("thrusday"));
		System.out.println(dictonary.get("friday"));
		System.out.println(dictonary.get("saturday"));
		System.out.println(dictonary.get("sunday"));
		// print out all keys.
		System.out.println(dictonary.keySet());
		// print our all values.
		System.out.println(dictonary.values());
		// print out size.
		System.out.println("size of the dictonary : " + dictonary.size());
	}
}