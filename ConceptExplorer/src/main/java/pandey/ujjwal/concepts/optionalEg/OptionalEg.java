package pandey.ujjwal.concepts.optionalEg;

import java.util.List;
import java.util.Optional;

public class OptionalEg {

	public static void main(String[] args) {
		exampleMethod();
	}

	private static void exampleMethod() {
		// Example value (could be null)
		String name = maybeGetName();

		// Create Optional
		// If using Optional.of(), it will throw error in case of empty value.
		Optional<String> opt = Optional.ofNullable(name);

		// Print value using ifPresent
		opt.ifPresent(n -> System.out.println("Name is present: " + n));
		String fallback = opt.orElse("Default Name");
		System.out.println("Fallback: " + fallback);

		// Combine both
		opt.ifPresentOrElse(
				n -> System.out.println("Name is present: " + n),
				() -> System.out.println("Name is absent"));

		String another = opt.orElseGet(() -> "else Name");
		System.out.println("OrElseGet: " + another);

		// OrElseThrow to throw exception if value absent
		try {
			String mustHave = opt.orElseThrow(() -> new IllegalArgumentException("Name missing!"));
			System.out.println("OrElseThrow: " + mustHave);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		// Example of using Optional with a method that returns null
		Optional<String> optionalName = Optional.ofNullable(maybeGetName());
		System.out.println("Optional Name: " + optionalName.orElse("No Name Provided"));
	}

	// Simulate a method that returns a String or null
	private static String maybeGetName() {
		return "Ujjwal"; // Uncomment for present value
		// return null; // Returns null to demonstrate Optional handling
	}
}
