package pandey.ujjwal.concepts.genericClass;

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
		System.out.println("A: " + a + " is: " + a.getClass());
		System.out.println("B: " + b + " is: " + b.getClass());
		System.out.println("c: " + z + " is: " + z.getClass());
	}
}

public class GenericClass {
	public static void main(String a[]) {
		test11<Integer, Character, String> obj = new test11<Integer, Character, String>(89, 'm', "ujjwal");
		obj.show();
	}
}