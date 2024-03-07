package objectToJson;

import java.sql.Timestamp;

public class POJO {
	private String stringVal;
	private long longVal;
	private int intVal;
	private boolean boolVal;
	private Timestamp dateTimeVal;

	public POJO() {
		super();
	}

	public POJO(String stringVal, long longVal, int intVal, boolean boolVal, Timestamp dateTimeVal) {
		super();
		this.stringVal = stringVal;
		this.longVal = longVal;
		this.intVal = intVal;
		this.boolVal = boolVal;
		this.dateTimeVal = dateTimeVal;
	}

	public String getStringVal() {
		return stringVal;
	}

	public void setStringVal(String stringVal) {
		this.stringVal = stringVal;
	}

	public long getLongVal() {
		return longVal;
	}

	public void setLongVal(long longVal) {
		this.longVal = longVal;
	}

	public int getIntVal() {
		return intVal;
	}

	public void setIntVal(int intVal) {
		this.intVal = intVal;
	}

	public boolean isBoolVal() {
		return boolVal;
	}

	public void setBoolVal(boolean boolVal) {
		this.boolVal = boolVal;
	}

	public Timestamp getDateTimeVal() {
		return dateTimeVal;
	}

	public void setDateTimeVal(Timestamp dateTimeVal) {
		this.dateTimeVal = dateTimeVal;
	}

	@Override
	public String toString() {
		return "POJO [stringVal=" + stringVal + ", longVal=" + longVal + ", intVal=" + intVal + ", boolVal=" + boolVal
				+ ", dateTimeVal=" + dateTimeVal + "]";
	}
}
