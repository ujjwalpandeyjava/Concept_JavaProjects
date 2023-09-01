package com.waysToGetBeans;

public class Study {
	private String whatTo;
	private String when;
	private Exam forExam;

	// Constructors
	public Study() {
		super();
	}

	public Study(String whatTo) {
		super();
		this.whatTo = whatTo;
	}

	public Study(String whatTo, String when, Exam forExam) {
		super();
		this.whatTo = whatTo;
		this.forExam = forExam;
		this.when = when;
	}

	@Override
	public String toString() {
		return "Study [whatTo=" + whatTo + ", when=" + when + ", forExam=" + forExam + "]";
	}

	public String getWhatTo() {
		return whatTo;
	}

	public void setWhatTo(String whatTo) {
		this.whatTo = whatTo;
	}

	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}

	public Exam getForExam() {
		return forExam;
	}

	public void setForExam(Exam forExam) {
		this.forExam = forExam;
	}

	void goStudyNow() {
		System.out.println("Method goStudyNow() called...");
	}

}
