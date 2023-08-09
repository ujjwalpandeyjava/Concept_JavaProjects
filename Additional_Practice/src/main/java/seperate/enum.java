class test {
	enum week {
		SUNDAY(6),
		MONDAY(5),
		TUESDAY(7),
		WEDNESDAY(8),
		THRUSDAY(9),
		FRIDAY(10),
		SATURDAY(11);

		private int valuew;

		private week(int valuew) {
			this.valuew = valuew;
		}
	}

	public static void main(String as[]) {
		for (week w : week.values()) {
			System.out.println(w.valuew);
		}
	}
}