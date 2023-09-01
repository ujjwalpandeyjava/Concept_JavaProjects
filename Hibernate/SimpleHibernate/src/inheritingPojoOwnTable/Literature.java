package inheritingPojoOwnTable;

public class Literature extends Book {
	private String authName;

	public Literature() {
		super();
	}

	public Literature(String authName) {
		super();
		this.authName = authName;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

}