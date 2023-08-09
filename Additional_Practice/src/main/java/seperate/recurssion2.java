class Recurssion
{
	static int count=0;	//static nhi htaana hai.	
	static void p()
	{	
		count++;
		if(count<=5)
		{
			System.out.println("ujjwal...");
			p();
		}
	}
	public static void main(String a[])
	{
		p();// o=new p();
	}
  
  
