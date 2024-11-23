package pandey.ujjwal.Oauth2.CustomRegisterLogin.enums;

public enum UserRole {
	SUPER_ADMIN("SUPER_ADMIN", "sa,a,r,w,d"), ADMIN("ADMIN", "r,w,d,a"), USER("USER", "r,w,d"), GUEST("GUEST", "r"),
	SUPPORT("SUPPORT", "r,w");

	private String userRole;
	private String defaultPriviliges;

	UserRole(String userRole, String defaultPrivilages) {
		this.userRole = userRole;
		this.defaultPriviliges = defaultPrivilages;
	}

	UserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getValue() {
		return userRole;
	}

	public String getPrivileges() {
		return this.defaultPriviliges;
	}

	public void setValue(String value) {
		this.userRole = value;
	}

	public static UserRole getRoleByValue(String value) {
		for (UserRole role : UserRole.values())
			if (role.getValue().equalsIgnoreCase(value))
				return role;
		return null;
		// or throw new IllegalArgumentException("Invalid role value: " + value);
	}

}
