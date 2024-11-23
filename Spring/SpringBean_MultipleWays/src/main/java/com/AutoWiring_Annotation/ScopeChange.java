package com.AutoWiring_Annotation;

public class ScopeChange {

	public ScopeChange() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String teName;

	public String getTeName() {
		return teName;
	}

	public void setTeName(String teName) {
		this.teName = teName;
	}

	public ScopeChange(String teName) {
		super();
		this.teName = teName;
	}

	@Override
	public String toString() {
		return "ScopeChange [teName=" + teName + "]";
	}

}
