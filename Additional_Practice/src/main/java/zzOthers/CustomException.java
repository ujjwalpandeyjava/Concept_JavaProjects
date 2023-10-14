package zzOthers;

import java.util.HashMap;
import java.util.Map;

public class CustomException {
	public static void main(String[] args) throws MyCustomEx {
		int number = 10;
		if (number == 10)
			throw new MyCustomEx("This is");

		String s1 = "listen";
		String s2 = "tilsen";
		Map<Character, Integer> availableChar = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			char charToCheck = s1.charAt(i);
			if (availableChar.containsKey(charToCheck)) {
				availableChar.put(charToCheck, availableChar.get(charToCheck) + 1);
			} else {
				availableChar.put(charToCheck, 1);
			}
		}
		for (int j = 0; j < s2.length(); j++) {
			char charToCheckEx = s2.charAt(j);
			if (availableChar.containsKey(charToCheckEx)) {
				availableChar.put(charToCheckEx, availableChar.get(charToCheckEx) - 1);
				if (availableChar.get(charToCheckEx) == 0)
					availableChar.remove(charToCheckEx);
			} else {
				System.out.println("Two strings does not have same charaters!");
			}
		}
		System.out.println(availableChar.size() > 0 ? "Two strings does not have same charaters!" : "Sa,e");

		int[] arr = { 3, 7, 9, 14 };
		String numberAndDiff = "";
		int maxDiff = -100;
		for (int i = 0; i < arr.length - 1; i++) {
			int numbe1 = arr[i];
			int numbe2 = arr[i + 1];
			if (Math.abs(numbe1 - numbe2) > maxDiff) { // 4, 2, 5
				numberAndDiff = "" + numbe1 + "--" + numbe2 + ", difference" + Math.abs(numbe1 - numbe2);
				maxDiff = Math.abs(numbe1 - numbe2);
			}
		}
		System.out.println(numberAndDiff);// 5

	}
}

class MyCustomEx extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyCustomEx() {
		// TODO Auto-generated constructor stub
	}

	MyCustomEx(String message) {
		System.out.print(message);
	}
}

/*
 * T1 = emp (id, mobileNo, emailID) t2 = salary (empID, salary)
 * 
 * 
 * Query: SELECT s.salary, e.emailID from emp e AND salary s where e.id ==
 * s.empID order by salary desc offset 1 limit 1; SELECT s.salary, e.emailID
 * from emp e AND salary s where s.salary > (select MAX(s2.salary) from emp e2
 * and salary s2 limit 1);
 */