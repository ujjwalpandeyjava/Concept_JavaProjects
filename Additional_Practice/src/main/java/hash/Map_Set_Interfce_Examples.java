package hash;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.WeakHashMap;

public class Map_Set_Interfce_Examples {
	public static void main(String[] args) {
		// Map interface implementers
		// HashTable, HashMap, LinkedHashMap, TreeMap, EnumMap, WeakHashMap
		Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();
		hashtable.put("one", 1);
		hashtable.put("two", 2);
		hashtable.put("three", 3);
		System.out.println("hashtable=>  " + hashtable);

		// HashMap
		HashMap<String, Integer> map = new HashMap<>();
		map.put("vishal", 10);
		map.put("sachin", 30);
		map.put("vaibhav", 20);
		System.out.println("map=>  " + map);

		// LinkedHashMap
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("One", 1);
		linkedHashMap.put("Two", 2);
		linkedHashMap.put("Three", 3);
		System.out.println("linkedHashMap=>  " + linkedHashMap);

		// TreeMap
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("A", 1);
		treeMap.put("C", 3);
		treeMap.put("B", 2);
		System.out.println("treeMap=>  " + treeMap);
		// EnumMap
		EnumMap<Days, String> enumMap = new EnumMap<>(Days.class);
		enumMap.put(Days.MONDAY, "Work");
		enumMap.put(Days.TUESDAY, "Work");
		enumMap.put(Days.WEDNESDAY, "Study");
		enumMap.put(Days.THURSDAY, "Study");
		enumMap.put(Days.FRIDAY, "Relax");
		System.out.println("enumMap=>  " + enumMap);
//		System.out.println(treeMap.values() + "" + enumMap.values() + ""+ enumMap.entrySet());

		// WeakHashMap
		/*
		 * In the WeakHashMap example, after setting key to null and calling
		 * System.gc(), the entry in the WeakHashMap will be garbage collected because
		 * there’s no strong reference to the key.
		 */
		WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
		Integer key = new Integer("1");
		weakHashMap.put(key, "value");
		System.out.println("weakHashMap=>  " + weakHashMap);
		key = null;
		System.gc();
		System.out.println("weakHashMap=>  " + weakHashMap);

		// Set interface
		// HashSet, LinkedHashSet, EnumSet, TreeSet
		// HashSet
		HashSet<String> set = new HashSet<>();
		set.add("Hello");
		set.add("World");
		System.out.println(set);

		// LinkedHashSet
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("One");
		linkedHashSet.add("Two");
		linkedHashSet.add("Three");
		System.out.println(linkedHashSet);

		// EnumSet
		EnumSet<Days> weekdays = EnumSet.range(Days.MONDAY, Days.FRIDAY);
		System.out.println(weekdays);

		// TreeSet
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("Hello");
		treeSet.add("World");
		System.out.println(treeSet);

	}
}

enum Days {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
