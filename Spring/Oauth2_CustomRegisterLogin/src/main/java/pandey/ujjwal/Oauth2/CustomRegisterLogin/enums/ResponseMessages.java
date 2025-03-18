package pandey.ujjwal.Oauth2.CustomRegisterLogin.enums;

public enum ResponseMessages {

	MESSAGE("MESSAGE"), DEFAULT("Default"), SUCCESS("Success"), ERROR("Error"), SERVER_ERROR("Server Error"),
	USER_NOT_FOUND("User Not Found"), INCORRECT_PASSWORD("Incorrect password"), SAVED("Saved"), NOT_SAVED("Not Saved");

	private String id = "";

	ResponseMessages(String responseMessage) {
		this.id = responseMessage;
	}

	public String getValue() {
		return id;
	}

	public void setValue(String value) {
		this.id = value;
	}

	public static ResponseMessages getPrivilageByValue(String value) {
		for (ResponseMessages eachValue : ResponseMessages.values())
			if (eachValue.getValue().equalsIgnoreCase(value))
				return eachValue;
		return null;
	}

//	@Override
	public String toString() {
		return this.getValue();
	}
}
