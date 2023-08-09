enum colour
{
	RED(),
	BLUE(),
	GREEN();
}
class test
{
	public static void main(String a[])
	{
		colour arr[]=colour.values();		
		for(colour c : arr)
		{System.out.println(c +" at " +c.RED); }
	}
}