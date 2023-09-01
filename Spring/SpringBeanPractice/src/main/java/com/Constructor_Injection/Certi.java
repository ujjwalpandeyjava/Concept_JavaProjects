package com.Constructor_Injection;

public class Certi {
	private String CertiName;
	private String CertiName2;

	public String getCertiName() {
		return CertiName;
	}
	public String getCertiName2() {
		return CertiName2;
	}

	public Certi(String certiName) {
		CertiName = certiName;
	}
	public Certi(String certiName, String certiName2) {
		super();
		CertiName = certiName;
		CertiName2 = certiName2;
	}
	@Override
	public String toString() {
		return "Certi [CertiName=" + CertiName + ", CertiName2=" + CertiName2
				+ "]";
	}
}