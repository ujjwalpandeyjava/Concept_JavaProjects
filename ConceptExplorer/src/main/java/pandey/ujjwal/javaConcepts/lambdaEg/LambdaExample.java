package pandey.ujjwal.javaConcepts.lambdaEg;

interface CustomFunctionalInterface {
	void workA();
}

class Car {
	public void startCar() {
		System.out.println("Car started.");
	}

	public void drive(CustomFunctionalInterface cfi) {
		System.out.println("Driving the car...");
		cfi.workA();
	}
}

/**
 * From java 8, before this we used anonymous class.
 * 
 * They are mainly used with functional interfaces.
 * 
 * In case the workA has parameters we have to pass it in the parameters of the
 * lambda expression () with data type most of the time.
 */
public class LambdaExample {
	public static void main(String[] args) {
		var c1 = new Car();
		c1.startCar();

		// Old way.
		c1.drive(new CustomFunctionalInterface() {

			@Override
			public void workA() {
				System.out.println("The CFI work with anonymous class.");
			}
		});

		// New way
		c1.drive(() -> {
			System.out.println("Car will run with lambda expression.");
			System.out.println("The CFI work with lambda expression.");
		});

		// New way (shorter for one liner)
		c1.drive(() -> System.out.println("The CFI work with lambda expression one liner."));
	}
}
