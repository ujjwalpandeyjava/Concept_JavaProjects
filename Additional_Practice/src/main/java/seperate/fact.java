class fact
{	/*Recurssion sei factorial*/
	int fac(int a)
	{	
		if(a==1)
		{
			//System.out.println(a);
			return 1;
		}
		else
		{
			System.out.println(a);
			return(a*fac(a-1));
		}	
	}
}
class fact1
{	
	public static void main(String a[])
	{
		fact obj=new fact();
		int t=obj.fac(5);		
		System.out.println(t);
	}
  }
  
