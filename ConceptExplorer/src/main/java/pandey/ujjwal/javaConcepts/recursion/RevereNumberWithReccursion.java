package pandey.ujjwal.javaConcepts.recursion;

import java.util.LinkedList;
import java.util.List;

public class RevereNumberWithReccursion {
	static List<Integer> numberWith10s = new LinkedList<>();

	public static void main(String[] args) {
		System.out.println("reversingNumber------- " + reversingNumber(123));
	}

	public static int reversingNumber(int numberToReverse) {// 123
		int lastDigit = numberToReverse % 10;
		int remainingDigit = numberToReverse / 10;
		if (remainingDigit < 10)
			return lastDigit;
		numberWith10s.add(lastDigit);
		numberWith10s.add(reversingNumber(remainingDigit)); // 3, 2, 1
		numberWith10s.add(remainingDigit / 10);

		System.out.println(numberWith10s.toString());

		int reversedNum = 0;
		for (int i = numberWith10s.size() - 1; i >= 0; i--) { // 3, 2, 1
			int theNum = numberWith10s.get(i);
			reversedNum = (int) (reversedNum + theNum * Math.pow(10, i)); // 1, 20, 300 = 321
		}
		return reversedNum;
		// Way 2
		/*
		 * if (num < 10) { return num; } else { int lastDigit = num % 10; int reversed =
		 * reverseNumber(num / 10); return (lastDigit * (int)Math.pow(10,
		 * (int)Math.log10(num))) + reversed; }
		 */
	}

}
