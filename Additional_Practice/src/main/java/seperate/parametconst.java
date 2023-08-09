class calculator //parameterized constructor.
{
	int rollno;
	String name;
	String collname;
	calculator( int roll,String nam,String coll)
	{
		rollno=roll;
		name=nam;
		collname=coll;
		
		System.out.println("Roll-no is :-" +rollno +"\nName is :-" +name +"\nCollege name is:-" +coll);
		System.out.println("\nParameterizes constructor fired...");
	}
}
class test2
{
	public static void main(String as[])
	{
		calculator cal=new calculator(222,"Pandey","IGNOU");		//Pass parameteres here for 
		//cal.Calculator(111,"Ujjwal","IGNOU");	//Pass parameteres here for 
	}
}