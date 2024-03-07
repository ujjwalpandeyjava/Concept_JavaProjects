package enums;

class AppEntryEnumsEg {
	public static void main(String a[]) {

		SingleValue enums[] = SingleValue.values();
		for (SingleValue c : enums)
			System.out.println(c + ": " + c.getValue());

		System.out.print("\n\n");
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