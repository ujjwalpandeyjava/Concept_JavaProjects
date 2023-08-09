package seperate;

import java.util.Scanner;

abstract class Shape {

	abstract void input();

	abstract void area();
}

class Circle extends Shape {

	Scanner scan = new Scanner(System.in);
	int radius;

	void input() {
		System.out.println("Enter the measurement of radius of circle:");
		radius = scan.nextInt();
	}

	void area() {
		System.out.println("Area of circle is: " + (3.14 * radius * radius));
	}
}

class Rectangle extends Shape {

	Scanner scan = new Scanner(System.in);
	int length, breath;

	void input() {
		System.out.println("Enter the measurement of length's side:");
		length = scan.nextInt();
		System.out.println("Enter the measurement of breath's side:");
		breath = scan.nextInt();
	}

	void area() {
		System.out.println("Area of Ractangle is: " + (length * breath));
	}
}

class Square extends Shape {

	Scanner scan = new Scanner(System.in);
	int side;

	void input() {
		System.out.println("Enter the measurement of square side:");
		side = scan.nextInt();
	}

	void area() {
		System.out.println("Area of square is: " + (side * side));
	}
}

public class Abstract1 {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		Shape sh;
		char rep = 'n';
		do {
			System.out.println(
					"Chosse from the option to find area of:\n 1. Circle\n 2. Rectangle\n 3. Square\n 4. Exit.");
			int swit;
			swit = scan.nextInt();
			switch (swit) {
			case 1:
				sh = new Circle();
				sh.input();
				sh.area();
				break;
			case 2:
				sh = new Rectangle();
				sh.input();
				sh.area();
				break;
			case 3:
				sh = new Square();
				sh.input();
				sh.area();
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
	}
}
