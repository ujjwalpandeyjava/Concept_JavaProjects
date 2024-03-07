package classTypes;

public class superexample {
	public static void main(String as[]) {
		B e = new B();
		e.show();
	}
}

class A {/* With super. */
	int a = 10;

	void show() {
		System.out.println("form show in A");
		System.out.println("a=" + a);
	}
}

class B extends A {
	int a = 20;
	int b = 44;

	void show() {
		super.show();
		System.out.println("form show in B");
		System.out.println("A=" + a);
		System.out.println("B=" + b);// new h.
	}
}
