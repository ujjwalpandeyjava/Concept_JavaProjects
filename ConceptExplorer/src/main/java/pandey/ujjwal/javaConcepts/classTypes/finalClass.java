package pandey.ujjwal.javaConcepts.classTypes;

final class Aa {
	Aa() {
		System.out.println("It is A.");
	}
}

//class Bb extends Aa { // cannot do thus, will show as syntax error
class Bb {
	Bb() {
		System.out.println("It is B.");
	}
}

class finalClass {
	@SuppressWarnings("unused")
	public static void main(String as[]) {
		Bb obj = new Bb();
	}
}