package com.Reference_Type_OR_MethodInjection;

public class A {
	private int aId;
	private B bObj;

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public B getbObj() {
		return bObj;
	}

	public void setbObj(B bObj) {
		this.bObj = bObj;
	}

	public A() {
		super();
		// TODO Auto-generated constructor stub
	}

	public A(int aId, B bObj) {
		super();
		this.aId = aId;
		this.bObj = bObj;
	}

	@Override
	public String toString() {
		return "A [aId=" + aId + ", bObj=" + bObj + "]";
	}

}
