package pandey.ujjwal.javaConcepts.enums;

public enum SingleValue {
	FROM("ujjwalpandey.aps@gmail.com"), CODE("esejextamtqoknpd"), TO("SomeOne");

	private String value;

	// enum constructor - Cannot be public or protected
	private SingleValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}