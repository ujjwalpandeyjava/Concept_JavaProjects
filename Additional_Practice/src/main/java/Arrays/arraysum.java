package Arrays;

import java.util.Scanner;

class arraysum {

	public static void main(String gg[]) {
		int arr[] = new int[4];
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter " + arr.length + " values:-");
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		arraysum.mate(arr);
		sc.close();
	}

	public static void mate(int array[]) {
		for (int i = 0; i < array.length; i++)
			System.out.println(String.valueOf(array[i]).concat(" - is an ").concat(array[i] % 2 == 0 ? "even" : "odd")
					.concat(" number"));
	}
}