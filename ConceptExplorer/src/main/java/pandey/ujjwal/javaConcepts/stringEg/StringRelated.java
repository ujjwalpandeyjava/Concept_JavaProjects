package pandey.ujjwal.javaConcepts.stringEg;

import java.util.Arrays;
import java.util.stream.Stream;

// String and similar classes
class StringRelated {

	public static void main(String[] args) {
		// 1. String
		int number0 = 90;
		float float0 = 69.49f;
		double double0 = 69.49d;
		String textBlock = """
				This is "Text blocks",
				Variable: %s, $%.3f, %s
				""".formatted(number0, float0, double0);
		System.out.println(textBlock);
		String S1 = "Simple string";
		S1.concat(" change will not add"); // Value doesn't get changed as we haven't assigned it to the field
		System.out.println(S1);
		S1 = S1.concat(" new String object assigned to same location"); // Now value get updated
		System.out.println(S1);

		// Remove white spaces from start, end
		String text = "   Strip will remove from leading and trailing whitespace.   ";
		String trimmedText = text.strip();
		String trimmedLeadingText = text.stripLeading();
		String trimmedTrailingText = text.stripTrailing();
		System.out.println(trimmedText); // This is a string with leading and trailing whitespace.
		System.out.println(trimmedLeadingText); // This is a string with trailing whitespace.
		System.out.println(trimmedTrailingText); // This is a string with leading whitespace.

		// Repeat string
		String oneTimeString = "Hello_";
		System.out.println(oneTimeString.repeat(3)); // Hello_Hello_Hello_

		//
		String oneLineString = "This is a string\n with multiple\n lines.\nBreaks whereever line break is added.";
		Stream<String> lines = oneLineString.lines();
		System.out.println(Arrays.toString(lines.toArray())); // [This is a string, with multiple lines.]

		// 2. StringBuffer
		StringBuffer sb = new StringBuffer();
		sb.append("Hello ");
		sb.append("world ");
		sb.append("between  ", 2, 5);
		System.out.println(sb);
		sb.delete(6, 7);
		System.out.println(sb);
		sb.deleteCharAt(7);
		System.out.println(sb);

		// 3. StringBuilder
		// Create a StringBuilder object using StringBuilder() constructor
		System.out.println("""

				StringBuilder Example""");
		// StringBuilder object using StringBuilder() constructor
		StringBuilder str0 = new StringBuilder();
		str0.append("AABBCC");
		System.out.println("String0: " + str0.toString());

		// StringBuilder object using StringBuilder(CharSequence) constructor
		StringBuilder str1 = new StringBuilder("AABBCCDD");
		System.out.println("String1: " + str1.toString());
		System.out.println("String1 capacity: " + str1.capacity());

		// StringBuilder object using StringBuilder(capacity) constructor
		// If the number of characters increases from its current capacity, it increases
		// the capacity by (oldCapacity*2)+2.
		StringBuilder str2 = new StringBuilder(3);
		str2.append("AAB");
		System.out.println("String2: " + str2.toString() + " | Capacity: " + str2.capacity());
		System.out.println("String2: " + str2.append("FFGGhhiijjkkll") + " | Capacity: " + str2.capacity());

		// StringBuilder object using StringBuilder(String) constructor
		StringBuilder str3 = new StringBuilder(str1.toString());
		System.out.println("String3: " + str3.toString());
	}
}
