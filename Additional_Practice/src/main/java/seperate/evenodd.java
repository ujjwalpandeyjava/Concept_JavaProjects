class evenodd
{
public static void main(String input[])
 {  
  int nos;
  int i;
nos=Integer.parseInt(input[0]);//use to take input from command line
if((nos%2)==0)
{
System.out.println(nos +"It is an even number.");
}
else
{
System.out.println(nos +" It is not an even number.");
}
 }
}
/*Enter 1 number to check even and odd*/