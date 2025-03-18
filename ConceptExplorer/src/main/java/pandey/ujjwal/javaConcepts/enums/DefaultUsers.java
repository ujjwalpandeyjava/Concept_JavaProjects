package pandey.ujjwal.javaConcepts.enums;

public enum DefaultUsers {
	ADMIN("uAdmin", "ADMIN", "passAdmin"), USER("uUSER", "USER", "passUser"), SIMPLE("uSIMPLE", "SIMPLE", "passSimple"),
	HELP("uHELP", "HELP", "passHelp");

	private final String userName;
	private final String role;
	private final String userPassword;

	DefaultUsers(String userName, String role, String userPassword) {
		this.userName = userName;
		this.role = role;
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getRole() {
		return role;
	}

	public String getUserPassword() {
		return userPassword;
	}
}
