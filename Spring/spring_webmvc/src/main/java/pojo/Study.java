package pojo;

public class Study {
	private String whatTo;
	private Exam when;

	// Constructors
	public Study() {
		super();
	}

	public Study(String whatTo) {
		super();
		this.whatTo = whatTo;
	}

	public Study(String whatTo, Exam when) {
		super();
		this.whatTo = whatTo;
		this.when = when;
	}

	// Getters Setters
	public String getWhatTo() {
		return whatTo;
	}

	public void setWhatTo(String whatTo) {
		this.whatTo = whatTo;
	}

	public Exam getWhen() {
		return when;
	}

	public void setWhen(Exam when) {
		this.when = when;
	}

	public void meet() {
		System.out.println("Student meets.");
	}

	@Override
	public String toString() {
		return "Study [whatTo=" + whatTo + " - when:-  " + when + "]";
	}

}
