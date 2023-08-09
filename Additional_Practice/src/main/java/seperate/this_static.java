class this_static
{/*Static and this use.
   Use static at all declaretion when You do not 
   want to make a object calling.
s */
static int roll_no;
static String name;
static float fee;
students(int roll_no, String name, float fee)	
 {
	this.roll_no=roll_no;
	this.name=name;
	this.fee=fee;
 }
static void display()
 {
	System.out.println("Roll-no: " +roll_no); 
	System.out.println("Name : " +name); 
	System.out.println("fee :" +fee); 
 }
 
 public static void main(String a[])
 {
	 display();
 }
}