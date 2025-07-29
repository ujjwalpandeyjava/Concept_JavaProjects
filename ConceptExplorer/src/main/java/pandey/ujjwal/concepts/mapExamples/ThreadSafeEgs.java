package pandey.ujjwal.concepts.mapExamples;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeEgs {
	public static void main(String[] args) {
		synchronizedHashMap(); // Slow - locks whole map
		// traversingConcurrentHashMap(); // Better - locks buckets only
	}

	private static void synchronizedHashMap() {
		// Create direct sync map or
		Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());
		// Access must be synchronized externally when iterating
		syncMap.put("10_", "Geeks");
		syncMap.put("20_", "for");
		syncMap.put("30_", "Geeks");
		syncMap.put("25_", "Welcome");
		syncMap.put("40_", "you");
		synchronized (syncMap) {
			for (String key : syncMap.keySet())
				System.out.println(key + " -> " + syncMap.get(key));
		}

		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(10, "Geeks");
		hmap.put(20, "for");
		hmap.put(30, "Geeks");
		hmap.put(25, "Welcome");
		hmap.put(40, "you");

		Map<Integer, String> map = Collections.synchronizedMap(hmap); // Creating an external synchronized map
		synchronized (map) {
			Iterator<Entry<Integer, String>> i = map.entrySet().iterator();
			while (i.hasNext()) {
				Entry<Integer, String> me = i.next();
				System.out.println(me.getKey() + ": " + me.getValue());
			}
		}
	}

	private static void traversingConcurrentHashMap() {
		Map<String, String> concurrentMap = new ConcurrentHashMap<>();
		concurrentMap.put("A", "Geeks");
		concurrentMap.put("B", "for");
		concurrentMap.put("C", "Geeks");
		concurrentMap.put("D", "Welcome");
		concurrentMap.put("E", "you");
		// No external sync needed while iterating
		for (String key : concurrentMap.keySet())
			System.out.println(key + " -> " + concurrentMap.get(key));

		// create an instance of ConcurrentHashMap
		ConcurrentHashMap<Integer, String> chmap = new ConcurrentHashMap<Integer, String>();
		chmap.put(10, "Geeks");
		chmap.put(20, "for");
		chmap.put(30, "Geeks");
		chmap.put(40, "Welcome");
		chmap.put(50, "you");

		// Create an Iterator over the
		// ConcurrentHashMap
		Iterator<ConcurrentHashMap.Entry<Integer, String>> itr = chmap.entrySet().iterator();

		// The hasNext() method is used to check if there is
		// a next element and the next() method is used to
		// retrieve the next element
		while (itr.hasNext()) {
			ConcurrentHashMap.Entry<Integer, String> entry = itr.next();
			System.out.println("Key = " + entry.getKey()
					+ ", Value = "
					+ entry.getValue());
		}
	}
}
