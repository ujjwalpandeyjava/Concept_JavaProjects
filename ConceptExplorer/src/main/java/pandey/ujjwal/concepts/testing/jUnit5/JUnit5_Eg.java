package pandey.ujjwal.concepts.testing.jUnit5;

public class JUnit5_Eg {

	public void simpleMethod() {
		System.out.println("simpleMehtod... Real result in JUnit tab");
	}

	public int methodWithOnePara(int numberToPrint) {
//		return numberToPrint++;	// Post-increment
		return ++numberToPrint; // Pre-increment
	}

	public int methodWithOneTwoPara(int num1, int num2) {
		return num1 + num2;
	}

	public int methodWithXPara(int... arrayOfP) {
		int total = 0;
		for (int i : arrayOfP)
			total += i;
		return total;
	}

}
