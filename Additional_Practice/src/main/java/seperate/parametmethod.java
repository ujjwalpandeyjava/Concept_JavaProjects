class calculator //parameterized method.
{
	int rollno;
	String name;
	String collname;
	void showDetails( int roll,String nam,String coll)
	{
		rollno=roll;
		name=nam;
		collname=coll;
		
		System.out.println("Roll-no is :-" +rollno +"\nName is :-" +name +"\nCollege name is:-" +coll);
		System.out.println("\nParaeterised method fired...");
	}
}
class test1
{
	public static void main(String as[])
	{
		calculator cal=new calculator();		//Pass parameteres here for 
		cal.showDetails(111,"Ujjwal","IGNOU");	//Pass parameteres here for 
	}
}