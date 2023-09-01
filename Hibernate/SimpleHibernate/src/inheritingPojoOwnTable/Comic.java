package inheritingPojoOwnTable;

public class Comic extends Book {
	private String authName;

	public Comic() {
		super();
	}

	public Comic(String authName) {
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