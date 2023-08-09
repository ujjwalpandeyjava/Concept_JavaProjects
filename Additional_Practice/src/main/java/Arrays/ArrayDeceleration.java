package Arrays;

import java.util.Arrays;

public class ArrayDeceleration {
	public static void main(String[] args) {
		// One dimensional
		int[] myArray1;
		int[] myArray2 = new int[5]; // Declare and allot size (all 0)
		int[] myArray3 = { 1, 2, 3, 4, 5 }; // Declare and initialize the array with values
		int myArray4[] = { 5 };
		int myArray5[] = new int[5];

		myArray1 = new int[3];
		myArray1[0] = (Integer) 44; // Initialize the array with size 10

		System.out.println(Arrays.toString(myArray1));
		System.out.println(Arrays.toString(myArray2));
		System.out.println(Arrays.toString(myArray3));
		System.out.println(Arrays.toString(myArray4));
		System.out.println(Arrays.toString(myArray5));
		System.out.println(myArray2); // Will print location of array.

		// Multi dimensional
		int[][] array2d = { { 1, 2 }, { 3, 4 }, { 5, 6, 7 } };

		System.out.println(Arrays.toString(array2d)); // Will give location of arr at i
		System.out.println(Arrays.deepToString(array2d)); // Will print full array [[], []]
	}
}
