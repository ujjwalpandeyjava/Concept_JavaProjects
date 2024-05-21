package pandey.ujjwal.javaConcepts.seperate;

class test11<T, Y, Z> {/* Multiple data type generic example */
	T a;
	Y b;
	Z z;

	test11(T a_, Y b_, Z z_) {
		a = a_;
		b = b_;
		z = z_;
	}

	void show() {
		System.out.println("A is Integer: " + a);
		System.out.println("B is character: " + b);
		System.out.println("Z is string: " + z);
	}
}

class multidatageneric {
	public static void main(String a[]) {
		test11<Integer, Character, String> obj = new test11<Integer, Character, String>(89, 'm', "ujjwal");
		obj.show();
	}
}