package seperate;

import java.util.Scanner;

class paro {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		// sc.nextLine();
		String str = sc.nextLine();
		int count = 0;
		{
			char str2[] = str.toCharArray();
			for (int i = 0; i < str.length(); i++) {
				int temp;
				temp = str2[i];
				if ((str2[i] == 'Z') || (str2[i] == 'z')) {
					temp = temp - 25;
					str2[i] = (char) temp;
					continue;
				}
				temp++;
				str2[i] = (char) temp;

			} // Printing new succive array...
			for (int i = 0; i < (str.length()); i++)
				System.out.print(str2[i]);

			// deleting same char..
			int n = str.length();
			for (int i = 0; i < (n - count); i++) {
				for (int j = (n - count - 1); j >= (i + 1); j--) /* u j j j w a l */
				{ /* 0 1 2 3 4 5 6 */
					if (str2[i] == str2[j]) {
						count++;
						for (int m = j; m < (n - 1); m++) {
							str2[m] = str2[m + 1];
							/* System.out.println(count); */}
					}
				}
			}
			System.out.println();
			for (int i = 0; i < (str.length() - count); i++)
				System.out.print(str2[i]);
			System.out.println();
		}
		sc.close();
	}
}