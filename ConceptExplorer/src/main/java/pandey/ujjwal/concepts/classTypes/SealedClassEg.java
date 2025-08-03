package pandey.ujjwal.concepts.classTypes;

public class SealedClassEg {

	public static void main(String[] args) {
		System.out.println("Sealed Class Example");
		// Sealed classes should be declared either final, sealed, or non-sealed
	}

	// ✅ Sealed base class: restricts who can extend
	public sealed class Vehicle permits Car, Car1, Truck {
	}

	// ✅ Final class: no further extension - if final no need to do more
	public final class Car extends Vehicle {
	}

	// ✅ Car1 permits only MonsterTruck - if sealed must use permits
	public sealed class Car1 extends Vehicle permits MonsterTruck {
	}

	// ✅ Non-sealed allows open extension - if non-sealed now it is simple class
	// and can be extended by any class
	public non-sealed class Truck extends Vehicle {
	}

	// ✅ Final class: no further extension
	public final class MonsterTruck extends Car1 {
	}

	// ✅ Bike can extend Vehicle but not Car1 or Truck
	public class Bike extends Truck {
	}

}
