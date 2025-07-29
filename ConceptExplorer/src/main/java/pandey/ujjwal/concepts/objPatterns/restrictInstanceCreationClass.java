package pandey.ujjwal.concepts.objPatterns;

// Not much helpful
// Limiting instance creation of objects like a lightweight object pool
public class restrictInstanceCreationClass {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		RestrictInstance obj;
		int a = 1;
		while (a <= 20) {
			obj = RestrictInstance.getLimInstance();
			a++;
		}
	}
}

class RestrictInstance {
	public volatile static int varCount = 0;
	private static final int MAX_INSTANCES = 5;

	/*
	 * create private constructor that increases the count of varCount variable
	 * after each instance creation
	 */
	private RestrictInstance() {
		varCount++;
		System.out.println("â€œInstance number: " + varCount + " is created.");
	}

	public static synchronized RestrictInstance getLimInstance() {
		if (varCount < MAX_INSTANCES)
			return new RestrictInstance();
		System.out.println("Maximum instance limit reached.");
		System.gc();
		return null;
	}

	/*
	 * delete the instance and decrease the count of the varCount variable
	 */
	public void finalize() {
		System.out.println("Instance is deleted.");
		varCount--;
	}
}