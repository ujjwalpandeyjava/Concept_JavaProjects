class evenoddsum {
  public static void main(String arry[]) {
    int i, n, sum1 = 0, sum2 = 0;
    n = Integer.parseInt(arry[0]);

    for (i = n; i < (n + 10); i++) {
      if (i % 2 == 0) {
        System.out.println(i + " is even");
        sum1 = sum1 + i;
      } else {
        System.out.println(i + " is Odd");
        sum2 = sum2 + i;
      }
    }

    System.out.println("Sum of even is =" + sum1);
    System.out.println("Sum of odd is  =" + sum2);
  }
}
/*
 * Enter a number to check its 10 consecutive odd even and sum of odd and even
 * seprately
 * and print prime number table
 */