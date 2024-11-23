package pandey.ujjwal.javaConcepts.patterns;

/* square pattern */
class Patterns {
	public static void main(String pt[]) {
		SquarePat(5);
		trianglePat(8);
		ReverseTriangle(4);
		CountTriangle(4);
		ReverseCountTriangle(5);
		ReverseFlipedTriangle(4);
		pyramid(4);
		ReverseFlipedCountTriangle(3);
	}

	public static void SquarePat(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print("* ");
			System.out.println("");
		}
		System.out.println("\n");
	}
// * * * * *
// * * * * *
// * * * * *
// * * * * *
// * * * * *

	public static void trianglePat(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print("* ");
			System.out.println("");
		}
		System.out.println("\n");
	}
// *
// * *
// * * *
// * * * *

	public static void ReverseTriangle(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = n; j > i; j--)
				System.out.print("* ");
			System.out.println("");
		}
		System.out.println("\n");
	}
// * * * *
// * * *
// * *
// *

	public static void CountTriangle(int height) {
		int m = 1;
		for (int i = 0; i <= height; i++) {
			for (int j = 0; j < i; j++)
				System.out.print(m++ + " ");
			System.out.println("");
		}
		System.out.println("\n");
	}

// 1
// 2 3
// 4 5 6
// 7 8 9 10

	public static void ReverseCountTriangle(int height) {
		int m = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 4; j > i; j--)
				System.out.print(m++ + " ");
			System.out.println("");
		}
		System.out.println("\n");
	}
//1 2 3 4
//5 6 7 
//8 9
//10

	public static void ReverseFlipedTriangle(int height) {
		int n = height + 1;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < i; j++)
				System.out.print("  ");
			for (int k = (n - i); k > (1); k--)
				System.out.print(" *");
			System.out.println("");
		}
		System.out.println("\n");
	}
// * * * *
//   * * *
//	   * * 
//	     * 

	public static void pyramid(int height) {
		for (int i = 0; i < height; i++) {
			for (int j = height - 1; j > i; j--)
				System.out.print(" ");
			System.out.print("*");
			for (int k = 1; k < (i + 1); k++)
				System.out.print("*");
			for (int k = 1; k < (i + 1); k++)
				System.out.print("*");
			System.out.println("");
		}
		System.out.println("\n");
	}
//	      *
//		   *** 
//		  *****

	static void ReverseFlipedCountTriangle(int height) {
		int m = 10;
		for (int i = 0; i < height; i++)
			for (int j = 0; j <= i; j++)
				m++;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < i; j++)
				System.out.print("   ");
			for (int k = height; k > i; k--)
				System.out.print(m-- + " ");
			System.out.println(" ");
		}
		System.out.println(" ");
	}
//20 19 18 17  
//   16 15 14  
//	    13 12  
//	       11 

	static void hourGlass() {
		
	}
//	
}