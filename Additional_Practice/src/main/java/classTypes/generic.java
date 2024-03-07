package classTypes;

class checkit<R, T> {
	R a;
	T b;

	checkit(R a_, T b_) {
		a = a_;
		b = b_;
	}

	void show() {
		System.out.println(a + " " + b);
	}
}

class generic {
	public static void main(String a[]) {
		checkit<Integer, Character> obj = new checkit<Integer, Character>(40, 'f');
		obj.show();
	}
}