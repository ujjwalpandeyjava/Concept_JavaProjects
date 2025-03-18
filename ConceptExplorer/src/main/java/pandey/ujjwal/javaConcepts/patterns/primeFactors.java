package pandey.ujjwal.javaConcepts.patterns;

public class primeFactors {
	public static void main(String[] args) {
		int nim = 81;
		for (int i = 2; i < nim; i++) {
			if (isPrimeLogN(i))
				if (nim % i == 0 && Math.sqrt((double) i * i) == i) {
					System.out.print(i + " ");
					continue;
				}
		}
	}

	// N-implementation
	static boolean isPrimeN(int n) {
		// Corner case
		if (n <= 1)
			return false;

		// Check from 2 to n-1
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	// Log(n)-implementation
	public static boolean isPrimeLogN(int n) {
		if (n <= 1)
			return false;

		// Check from 2 to n-1
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
