package com.AutoWiring_StandaloneColl;

public class Education {
	private String graduate;
	private String postGraduate;
	public String getGraduate() {
		return graduate;
	}
	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}
	public String getPostGraduate() {
		return postGraduate;
	}
	public void setPostGraduate(String postGraduate) {
		this.postGraduate = postGraduate;
	}
	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Education(String graduate, String postGraduate) {
		super();
		this.graduate = graduate;
		this.postGraduate = postGraduate;
	}
	@Override
	public String toString() {
		return "Education [graduate=" + graduate + ", postGraduate="
				+ postGraduate + "]";
	}

}
