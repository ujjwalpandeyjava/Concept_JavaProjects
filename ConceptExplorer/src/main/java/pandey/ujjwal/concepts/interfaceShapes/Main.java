package pandey.ujjwal.concepts.interfaceShapes;

import java.util.Scanner;

import pandey.ujjwal.concepts.interfaceShapes.interfaces.Shapes;
import pandey.ujjwal.concepts.interfaceShapes.pack2.Circle;
import pandey.ujjwal.concepts.interfaceShapes.pack3.Rectangle;
import pandey.ujjwal.concepts.interfaceShapes.pack4.Square;

public class Main {

  static Shapes ob;
  static Scanner scan = new Scanner(System.in);

  public static void main(String sa[]) {
    char rep = 'n', ca;
    System.out.println(
      "Choose from the options and perform action:\n1. Circle\n2. Rectangle\n3. Square\n4. Exit."
    );
    ca = scan.next().charAt(0);
    do {
      switch (ca) {
        case '1':
          ob = new Circle();
          ob.input();
          ob.perameters();
          ob.area();
          ob.filled();
          break;
        case '2':
          ob = new Rectangle();
          ob.input();
          ob.perameters();
          ob.area();
          ob.filled();
          break;
        case '3':
          ob = new Square();
          ob.input();
          ob.perameters();
          ob.area();
          ob.filled();
          break;
        case '4':
          System.exit(0);
        default:
          System.out.println("Enter a valid char from the options.");
          break;
      }
      System.out.println("\nEnter y to repeat the action:::");
      rep = scan.next().charAt(0);
    } while (rep == 'Y' || rep == 'y');
  }
}
