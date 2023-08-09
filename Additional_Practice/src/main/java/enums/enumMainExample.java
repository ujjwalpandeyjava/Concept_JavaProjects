package enums;

class enumMainExample {
	public static void main(String a[]) {

		MailDetails enums[] = MailDetails.values();
		for (MailDetails c : enums)
			System.out.println(c + ": " + c.getValue());

		System.out.print("\n\n");
		EnumMultipleValues emv[] = EnumMultipleValues.values();
		for (EnumMultipleValues c : emv)
			System.out.println(c + ": " + c.getValues());

		System.out.print("\n\n");
		System.out.println(EnumMultipleValues.valueOfLabel("Helium"));
		System.out.println(EnumMultipleValues.LI.getLabel());
		System.out.println(EnumMultipleValues.LI.getNumber());
		System.out.println(EnumMultipleValues.LI.getWeight());
		System.out.println(EnumMultipleValues.LI.getValues());
	}
}