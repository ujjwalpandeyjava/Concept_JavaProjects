package enums;

public enum MailDetails {
	FROM("ujjwalpandey.aps@gmail.com"), CODE("esejextamtqoknpd"), TO("SomeOne");

	private String value;

	// enum constructor - Cannot be public or protected
	private MailDetails(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}