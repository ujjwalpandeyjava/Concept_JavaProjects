package pandey.ujjwal.javaConcepts.classTypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Inner classes are also known as nested classes.
 * 
 * They cannot be public, private or protected.
 * 
 * Types: 1. Inner/Nested class 2. Static nested class 3. Local inner class 4.
 * Anonymous inner class.
 * 
 * Cannot access the inner classes other then the enclosing class.
 */
public class Inner_Nested_Classes {
	public static void main(String[] args) {

		// Nested class
		var machine = new MachinePOJO(10);
		machine.work();

		System.out.println("\n\n");

		var m2 = new MachinePOJO(20);
		m2.work();

		/**
		 * Definition: Anonymous classes in Java are a nifty tool for creating a
		 * one-time-use class that doesn't need a name.
		 * 
		 * Use case: Need a quick, unique implementation of a class, and you don't want
		 * to clutter your code with a separate class file.
		 * 
		 * Here Comparator<String> is anonymous class.
		 */
		Comparator<String> stringLengthComparator = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		};

		List<String> strings = Arrays.asList("Apple", "Banana", "Kiwi", "Pineapple");
		Collections.sort(strings, stringLengthComparator);

		System.out.println(strings); // Output: [Kiwi, Apple, Banana, Pineapple]

	}
}
