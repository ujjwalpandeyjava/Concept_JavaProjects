class patt7
{
public static void main(String pt[])
  { int n=5;
    for(int i=0;i<n;i++)
	{for(int j=n;j>i;j--)
		{System.out.print("  ");}
	System.out.print("*"); 
		for(int k=1;k<(i+1);k++)
		{System.out.print(" *");}	
	   	for(int k=1;k<(i+1);k++)
		{System.out.print(" *");}
	System.out.println("");
    }
  }
}/*
        *
	   *** 
	  *****
	 *******
	*********
*/