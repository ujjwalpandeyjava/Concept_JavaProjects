class patt8
{ 
public static void main(String jj[])
  { int m=10;
	for(int i=0;i<4;i++)
	{
	 for(int j=0;j<i;j++)
	 {
	 System.out.print("  ");
	 }
	 for(int k=4;k>i;k--)
	 {   System.out.print(m +" ");
		m--;
	 }System.out.println(" ");
	}
  }
}/*
10 9 8 7
   6 5 4
     3 2 
       1 
/