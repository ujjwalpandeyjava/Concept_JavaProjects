package Arrays;

// Array shorting.
import java.util.Scanner;

class test11 {

	public static void main(String as[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the no. of integers you want to enter:-");
		int n = scanner.nextInt();
		int array[] = new int[n];

		System.out.println("Enter the number:-");
		for (int i = 0; i < n; i++)
			array[i] = scanner.nextInt();

		System.out.print("You entered: ");
		for (int i = 0; i < n; i++)
			System.out.print(array[i] + " ");

		// Arranging in orders.
		System.out.println("Choose form it according to need:-\n1). Descending order.\n2). Ascending order.	\n");
		int chosenOrder = scanner.nextInt();
		if (chosenOrder == 1) {
			for (int i = 0; i < n; i++)
				for (int j = (i + 1); j < n; j++)
					if (array[i] < array[j]) {
						array[i] = array[i] + array[j];
						array[j] = array[i] - array[j];
						array[i] = array[i] - array[j];
					}
		} else
			for (int i = 0; i < n; i++)
				for (int j = (i + 1); j < n; j++)
					if (array[i] > array[j]) {
						array[i] = array[i] + array[j];
						array[j] = array[i] - array[j];
						array[i] = array[i] - array[j];
					}

		System.out.println("Arranged values are:- ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		scanner.close();
	}
}
