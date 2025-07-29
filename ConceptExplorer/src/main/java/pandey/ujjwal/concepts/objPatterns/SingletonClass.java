package pandey.ujjwal.concepts.objPatterns;
// Singleton class

// How a private constructor in Java limits the number of instances in a singleton class.

public class SingletonClass {
	public static void main(String args[]) {
		SingleTonEx instance1 = SingleTonEx.getInstance();
		// displaying the instance of the singleton class by calling the public method
		SingleTonEx instance2 = SingleTonEx.getInstance();
		// displaying the instance of the singleton class by calling the public method
		System.out.println("Instance 1 created has the following value = " + instance1);
		System.out.println("Instance 2 created has the following value = " + instance2
				+ " (we didn't added any no. to 20- the initial no.)");
	}
}

class SingleTonEx {
	// Private constructor to prevent instantiation from outside the class
	private SingleTonEx() {
	}

	private static SingleTonEx instance = null;

	// we have created a private constructor
	public static SingleTonEx getInstance() {
		if (instance == null)
			instance = new SingleTonEx(); // private can be only accessed here.
		return instance;
	}

	// int schoolName = "APS";

	// private void name() { }
	// Optional: Add methods and properties for the singleton instance
}