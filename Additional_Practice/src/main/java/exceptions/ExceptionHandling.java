package exceptions;

import java.util.Arrays;
import java.util.Scanner;

class ExceptionHandling {
	public static void main(String sa[]) {
		System.out.println("Enter two numbers to divide: ");
		Scanner scan = new Scanner(System.in);
		try {
			int a = scan.nextInt();
			int b = scan.nextInt();
			float c = a / b;
			System.out.println("C= " + c);
			int arr[] = { 1, 2, 3, 4, 5, 6 };
			System.out.println("Enter the array position to eneer the value on it (under: " + arr.length + " ):-");
			int d = scan.nextInt();
			System.out.println("Enter the value to enter.");
			System.out.println("Current array: " + Arrays.toString(arr));
			arr[d] = scan.nextInt();
			System.out.println("New array: " + Arrays.toString(arr));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Enter on a valid positon.\n" + e);
		} catch (ArithmeticException e) {
			System.out.println("Cannot Proceed because you entered zero which is not valide." + e + "\n");
			e.printStackTrace();
		} finally {
			System.out.println("-----Tata-----");
		}
		scan.close();
	}
}