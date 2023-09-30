package pandey.ujjwal.Oauth2.CustomRegisterLogin.enums;

public enum UserTypes {
	USER("USER"), ADMIN("ADMIN");

	private String value;

	UserTypes(String s) {
		value = s;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
