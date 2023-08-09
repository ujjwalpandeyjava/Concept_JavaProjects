import java.util.Scanner;

// use public access modifier and have to make class and file name same
class ScannerRelated {
  public static void main(String[] args) {

    // Way 1, where resource is never closed until we close it.
    Scanner scan = new Scanner(System.in);

    int i = 4;
    double d = 4.0;
    String s = "HackerRank ";

    // Reads from input console
    int i1 = scan.nextInt();
    double d1 = scan.nextDouble();
    String s1 = scan.nextLine();

    System.out.println("int: " + i + i1);
    System.out.println("double: " + d + d1);
    System.out.print("String: " + s.concat(s1)); // Correct way of using concatenate.
    scan.close(); // closed here

    // Way 2, where resource is closed after use.
    try (Scanner scanner2 = new Scanner(System.in)) {
      String inputString = scanner2.nextLine(); // reads string form input..
      System.out.println("All logic goes same: \n" + inputString);
    }

  }
}