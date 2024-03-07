package gettersSetters;

import java.util.Scanner;

public class Main extends Takes {

	public Main(int x, String s, float f) {
		super(x, s, f);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int x = scan.nextInt();
		System.out.println("Enter the Name: ");
		scan.nextLine();
		String s = scan.nextLine();
		System.out.println("Enter the float number: ");
		float f = scan.nextFloat();
		Takes obj = new Takes(x, s, f);

		// Printing the private values
		System.out.println("The value of x = " + obj.getX());
		System.out.println("Name is = " + obj.getS());
		System.out.println("The value of float number is = " + obj.getF());
		scan.close();
	}
}
