package pandey.ujjwal.javaConcepts.threads;

/**
 * Used to sync threads to a basic level.
 * 
 * Share/allowes a thread to read the changes by another thread.
 */
public class Volatile_KV {

	private volatile static String workHere = "The work";

	public static void main(String[] args) {
		System.out.println("Example of keyword volatile keyword." + workHere);
	}

}
