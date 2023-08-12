package seperate;

class take {
	/* With final */
	final static int a = 444;
	static int b = 555;

	static void show(int a_, int b_) {
//		this.a = a_; // cannot
		b = b_;
		System.out.println("The value of a:" + a);
		System.out.println("The value of b:" + b);
	}
}

class final_ {
	public static void main(String as[]) {
		take.show(4, 5);
	}

}