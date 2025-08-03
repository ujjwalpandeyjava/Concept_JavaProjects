package pandey.ujjwal.concepts.interfaceEg;

import java.util.Scanner;

interface Shape {
	void input();

	void area();
}

class Circle implements Shape {
	Scanner scan = new Scanner(System.in);
	int radius;

	public void input() {
		System.out.println("Enter the measurement of radius of circle:");
		radius = scan.nextInt();
	}

	public void area() {
		System.out.println("Area of circle is: " + (3.14 * radius * radius));
	}
}

class Rectangle implements Shape {
	Scanner scan = new Scanner(System.in);
	int length, breath;

	public void input() {
		System.out.println("Enter the measurement of length's side:");
		length = scan.nextInt();
		System.out.println("Enter the measurement of breath's side:");
		breath = scan.nextInt();
	}

	public void area() {
		System.out.println("Area of Ractangle is: " + (length * breath));
	}
}

class Square implements Shape {
	Scanner scan = new Scanner(System.in);
	int side;

	public void input() {
		System.out.println("Enter the measurement of square side:");
		side = scan.nextInt();
	}

	public void area() {
		System.out.println("Area of square is: " + (side * side));
	}
}

public class InterfaceTest {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		char rep = 'n';
		do {
			System.out.println("Choose from the option to find area of:\n 1. Circle\n 2. Rectangle\n 3. Square\n 4. Exit.");
			int itVar;
			itVar = scan.nextInt();
			switch (itVar) {
			case 1:
				Circle sh = new Circle();
				sh.input();
				sh.area();
				break;
			case 2:
				Rectangle sh1 = new Rectangle();
				sh1.input();
				sh1.area();
				break;
			case 3:
				Square sh2 = new Square();
				sh2.input();
				sh2.area();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Chosse form the given options only ");
			}
			System.out.println("Press y if you want to retry: ");
			rep = scan.next().charAt(0);
		} while (rep == 'Y' || rep == 'y');
		scan.close();
	}
}