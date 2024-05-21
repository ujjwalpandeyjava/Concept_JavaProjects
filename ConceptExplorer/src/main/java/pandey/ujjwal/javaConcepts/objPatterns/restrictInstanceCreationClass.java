package pandey.ujjwal.javaConcepts.objPatterns;
// Limiting the no. of objects

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
	public static int varCount = 0;

	/*
	 * create private constructor that increases the count of varCount variable
	 * after each instance creation
	 */
	private RestrictInstance() {
		varCount++;
		System.out.println("â€œInstance number â€�" + varCount + " is created.");
	}

	public static synchronized RestrictInstance getLimInstance() {
		if (varCount < 5)
			return new RestrictInstance();
		System.out.println("Maximum instance limit reached. You are not allowed to create anymore instances.");
		System.gc();
		return null;
	}

	/*
	 * delete the instance and decrease the count of the varCount variable
	 */
	public void finalise() {
		System.out.println("Instance is deleted.");
		varCount--;
	}
}