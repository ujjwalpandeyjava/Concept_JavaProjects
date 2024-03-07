package staticEg;

/*
 * Static and this use. Use static at all declaretion when You do not want to
 * make a object calling. s
 */
class this_static {
	static int roll_no;
	static String name;
	static float fee;

	static {
		roll_no = 001;
		name = "Name String";
		fee = (float) 65.2;
	}

	static void display() {
		System.out.println("Roll-no: " + roll_no);
		System.out.println("Name : " + name);
		System.out.println("fee :" + fee);
	}

	public static void main(String a[]) {
		display();
	}
}