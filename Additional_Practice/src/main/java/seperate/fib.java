class fib
{
public static void main(String ant[])
  {
  int n,a=1,b=1,sum=0;
  n=Integer.parseInt(ant[0]);
  System.out.println(b);
  System.out.println(a);		
   for(sum=0;sum<n;)
    {  
	sum=a+b;
	if (sum <=n)
        {System.out.println(sum);}
	a=b;
	b=sum;
    }
  }
}
/*Enter a number to print fibnic series
  upto entered number*/