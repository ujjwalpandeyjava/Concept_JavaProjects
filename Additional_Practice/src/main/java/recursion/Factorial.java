package recursion;

class Factorial { /* Recurssion sei factorial */
	int fac(int a) {
		return (a == 1) ? 1 : (a * fac(a - 1));
	}
}

class fact1 {
	public static void main(String a[]) {
		Factorial obj = new Factorial();
		System.out.println(obj.fac(5));
	}
}
