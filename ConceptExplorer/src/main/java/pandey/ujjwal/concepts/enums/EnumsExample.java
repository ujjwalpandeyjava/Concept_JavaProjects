package pandey.ujjwal.concepts.enums;

/**
 * Definition: Enumeration a feature that allows defining a set of named
 * constants.
 * 
 * Used to represent a fixed set of known values in a type-safe manner.
 * 
 * Features: - Compile time type safety, - Pre-defined constants, - methods and
 * fields, - and use iterators
 */
class EnumsExample {
	public static void main(String a[]) {

		var myColor = SimpleEnum_Color.RED;
		System.out.println(myColor.getClass());
		System.out.println(myColor);
		myColor.display();
		System.out.print("\n\n");

		SimpleEnum_Color day = SimpleEnum_Color.GREEN;
		switch (day) {
		    case RED:
		        System.out.println("Red are tough.");
		        break;
		    case BLUE:
		        System.out.println("Blue are fun!");
		        break;
		    case GREEN:
		        System.out.println("Green are fun!");
		        break;
		}
		System.out.print("\n\n");
		
		// With field and method
		SingleValue enums[] = SingleValue.values();
		for (SingleValue c : enums)
			System.out.println(c + ": " + c.getValue());
		System.out.print("\n\n");

		// With fields and methods
		MultipleValuesEg emv[] = MultipleValuesEg.values();
		for (MultipleValuesEg c : emv)
			System.out.println(c + ": " + c.getValues());
		System.out.print("\n\n");

		System.out.println(MultipleValuesEg.valueOfLabel("Helium"));
		System.out.println(MultipleValuesEg.LI.getLabel());
		System.out.println(MultipleValuesEg.LI.getNumber());
		System.out.println(MultipleValuesEg.LI.getWeight());
		System.out.println(MultipleValuesEg.LI.getValues());
	}
}