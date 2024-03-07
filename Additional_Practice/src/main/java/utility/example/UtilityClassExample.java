package utility.example;

/* 
  Utilities: Create at once and use anywhere
 */

public class UtilityClassExample {

  static int sum(int a, int b) {
    return (a + b);
  }

  static int sub(int a, int b) {
    return (a - b);
  }

  public static void main(String args[]) {
    int sum = MathUtils.add(5, 10);
    int diff = MathUtils.subtract(10, 5);
    System.out.println(sum);
    System.out.println(diff);
    // Cannot create their object as they are final and have private constructors.
    // System.out.println(new MathUtils());	// throws error constructor not visible (Due to it is private)
  }
}
