package pandey.ujjwal.concepts.patterns;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Print entered string with one successive alphabet, and distinct alphabets
 */
public class successiveAlphabet {
	public static void main(String arg[]) {
		System.out.println("Enter:");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char str2[] = str.toCharArray();
		{
			int n = str.length();
			for (int i = 0; i < n; i++) {
				int temp = str2[i];
				str2[i] = (char) (((str2[i] == 'Z') || (str2[i] == 'z')) ? (temp - 25) : ++temp);
			}
			System.out.print("With one car furhter: ");
			for (int i = 0; i < (str.length()); i++)
				System.out.print(str2[i]);
			System.out.println();

			var distince = new LinkedHashSet<String>();
			for (int i = 0; i < n; i++)
				distince.add(Character.toString(str2[i]));
			System.out.println("\nWithout duplicates: " + distince.toString());
		}
		sc.close();
	}
}