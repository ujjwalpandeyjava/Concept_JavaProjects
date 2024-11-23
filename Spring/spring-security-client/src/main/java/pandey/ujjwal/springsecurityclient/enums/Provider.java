package pandey.ujjwal.springsecurityclient.enums;

public enum Provider {
	LOCAL("LOCAL"), GOOGLE("GOOGLE"), GITHUB("GITHUB");

	public final String label;

	private Provider(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}