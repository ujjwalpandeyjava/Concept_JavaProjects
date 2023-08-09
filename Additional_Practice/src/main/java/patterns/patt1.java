class patt1 {
	public static void main(String pt[]) {
		/*
		 * for (int i = 0; i < 5; i++) {
		 * for (int j = 0; j < 5; j++) {
		 * System.out.print("* ");
		 * }
		 * System.out.println(" ");
		 * }
		 */
		System.out.println("Test");
		String ref = "Practitioner/111";
		System.out.println(ref.substring(ref.indexOf("/") + 1));
		System.out.println(ref.substring(ref.indexOf("/") + 1).getClass());
	}
}
/* square pattern */