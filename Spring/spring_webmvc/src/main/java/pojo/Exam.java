package pojo;

public class Exam {
	private String s;

	// Constructors
	public Exam(String s) {
		super();
		this.s = s;
	}

	public Exam() {
		super();
		this.s = "Nothing";
	}

	// Getter Setters
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	// Overridden methods
	@Override
	public String toString() {
		return "From ExamtoString [s=" + s + "]";
	}

}
