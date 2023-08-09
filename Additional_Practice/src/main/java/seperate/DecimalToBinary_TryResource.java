import java.util.Scanner;

public class DecimalToBinary {
  String dtb(int n) {
    String binary = "";
    if (n == 0) {
      return "0";
    } else {
      while (n > 0) {
        int temp;
        temp = n % 2;
        binary = binary + temp;
        n = n / 2;
      }
      char[] binary2 = binary.toCharArray();
      String binaryre = "";
      for (int i = binary2.length - 1; i >= 0; i--) {
        binaryre += binary2[i];

      }
      return binaryre;
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scanner.nextInt();
    DecimalToBinary Sol = new DecimalToBinary();
    String ans = Sol.dtb(n);
    System.out.println(ans);
    scanner.close();
  }
}
