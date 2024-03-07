package com.Reference_Type_OR_MethodInjection;

public class B {
	private int bId;

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public B(int bId) {
		super();
		this.bId = bId;
	}

	public B() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "B [bId=" + bId + "]";
	}

}
