class take {
	/* With final */
	final int a = 444;
	int b = 555;

	void show(int a_, int b_) {
		a = a_;
		b = b_;
		System.out.println("The value of a:" + a);
		System.out.println("The value of b:" + b);
	}
}

class final_ {
	public static void main(String as[]) {
		take t1 = new take();
		t1.show(4, 5);
	}
}