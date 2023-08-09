package seperate;

import java.util.Scanner;

public class DecimalToBinary_TryResource {
	public static void main(String[] args) {
		System.out.print("Enter an integer: ");
		Integer integer = 0;
		try (Scanner scanner = new Scanner(System.in);) {
			integer = Integer.parseInt(scanner.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println("Enter integer only!");
			return;
		}
		System.out.println(dtb(integer));
	}

	static String dtb(Integer n) {
		String binary = "";
		if (n == 0)
			return "0";
		else if (n == 1)
			return "1";
		else {
			while (n > 1) {
				int temp;
				temp = n % 2;
				binary = binary + temp;
				n = n / 2;
			}
			char[] binary2 = binary.toCharArray();
			String binaryre = "";
			for (int i = binary2.length - 1; i >= 0; i--)
				binaryre += binary2[i];
			return binaryre;
		}
	}
}