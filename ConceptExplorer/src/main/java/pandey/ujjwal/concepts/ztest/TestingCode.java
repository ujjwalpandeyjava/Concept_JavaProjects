package pandey.ujjwal.concepts.ztest;

public class TestingCode {

	public static void main(String arg[]) {
		countAndDisplayEvens(3);
	}

	public static void countAndDisplayEvens(int limit) {
		for (int i = 2; i <= limit; i += 2) {
            System.out.println(i);
        }
	}
}
