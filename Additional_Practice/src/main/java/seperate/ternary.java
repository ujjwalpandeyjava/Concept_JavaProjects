import java.util.Scanner;
class ternary//Alternate of for loop...
{
	public static void main(String s[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number to find it's table:");
		int numb=sc.nextInt();
		
		
		System.out.println((numb%2==0)? ("This number is Even.\n"  ) :("This number is odd.\n" ));
	}						//Here it is ...
}