package seperate;

import java.util.Scanner;

class prime/* Enter numbers to check prime and print prime table. */
{
	public static void main(String input[]) {
		Scanner sc = new Scanner(System.in);
		int count, nos, n;
		System.out.println("Enter how many numbers you want to check (do not enter 1):- ");
		n = sc.nextInt();
		int array[] = new int[n];
		System.out.println("Enter " + n + " numbers :- ");
		for (int i = 0; i < n; i++)
			array[i] = sc.nextInt();

		for (int i = 0; i < n; i++) {
			count = 0;
			nos = array[i];
			for (int j = 2; j < nos; j++) {
				if (count == 0 && (nos % j) == 0) {
					count++;
					System.out.println("It is not a prime number:- " + nos);
					break;
				}
			}
//			if (count != 1) {
//				System.out.println("It is a prime number:-" + nos + "\n" + "Here is a table of prime number " + nos);
//				for (int k = 1; k < 11; k++)
//					System.out.println("        " + nos + "*" + k + "=" + (nos * k));
//			}
		}
		sc.close();
	}
}
