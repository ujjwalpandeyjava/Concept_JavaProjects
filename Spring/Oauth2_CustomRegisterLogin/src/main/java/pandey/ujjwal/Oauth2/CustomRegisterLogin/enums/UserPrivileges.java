package pandey.ujjwal.Oauth2.CustomRegisterLogin.enums;

import java.util.LinkedList;
import java.util.List;

public enum UserPrivileges {
	WRITE("w"), READ("r"), DELETE("d"), SUPER_ADMIN("sa"), ADMIN("a");

	private String value = "";

	UserPrivileges(String privilage) {
		this.value = privilage;
	}

	UserPrivileges(List<String> privileges) {
		for (String eachprivilage : privileges)
			this.value.concat(eachprivilage);
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String... value) {
		for (String eachValue : value)
			this.value.concat(eachValue);
	}

	public static UserPrivileges getPrivilageByValue(String value) {
		for (UserPrivileges eachPrivilage : UserPrivileges.values())
			if (eachPrivilage.getValue().equalsIgnoreCase(value))
				return eachPrivilage;
		return null;
		// or throw new IllegalArgumentException("Invalid role value: " + value);
	}

	public static List<String> getAllValues() {
		LinkedList<String> linkedList = new LinkedList<String>();
		for (UserPrivileges eachPrivilage : UserPrivileges.values()) {
			linkedList.add(eachPrivilage.getValue());
		}
		return linkedList;
	}

}
