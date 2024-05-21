package pandey.ujjwal.javaConcepts.seperate;

import java.util.Scanner;

class matrixques {
	public static void main(String am[]) {
		Scanner scc = new Scanner(System.in);
		System.out.println("Enter a number to  form it's square matrix:-");
		int num = scc.nextInt();
		System.out.println("Enter " + (num * num) + " elements of num*num matrix:- ");
		int mat[][] = new int[num][num];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				mat[i][j] = scc.nextInt();
			}
		}

		System.out.println(" Your entered matrix is :");
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println(" ");
		}
// It is for diagonal printing
		System.out.println(" Your entered matrix diagonal is :");
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (i == j) {
					for (int l = 0; l < i; l++) {
						System.out.print("  ");
					} // we can also reduce {} form here which give the error advantage
					System.out.print(mat[i][j] + "");
				} // print 1st line according to loop and 2nd line once.
			}
			System.out.println();
		}
//It is for sum of individual rows and columns.
		System.out.println(" Your entered matrix individual sum of row and column are: ");
		int sum1 = 0;
		for (int j = 0; j < num; j++) {
			for (int i = 0; i < num; i++) {
				sum1 += mat[i][j];
			}
			System.out.println("Sum of row " + (j + 1) + " is " + sum1);
			sum1 = 0;
		}

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				sum1 += mat[i][j];
			}
			System.out.println("Sum of colummn " + (i + 1) + " is " + sum1);
			sum1 = 0;
		}
//It is to show palindrome of  each element(mughe nhi aata...).  
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				int reverse = 0, temp;
				temp = mat[i][j];
				while (temp != 0) // It is still not clear to me.
				{
					reverse = reverse * 10;
					reverse = reverse + temp % 10;
					temp = temp / 10;
				}
				if (mat[i][j] == reverse) {
					System.out.println(mat[i][j] + " is a palindrome number.");
				} else {
					System.out.println(mat[i][j] + " is not a palindrome number.");
				}
			}
		}
		scc.close();
	}
}