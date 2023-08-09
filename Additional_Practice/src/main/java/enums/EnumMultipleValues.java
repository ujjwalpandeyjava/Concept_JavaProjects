package enums;

import java.util.HashMap;
import java.util.Map;

// Constructor and static block both runs for every enum
public enum EnumMultipleValues {
	H("Hydrogen", 1, 1.008f), HE("Helium", 2, 4.0026f), LI("Litium", 10, 20.180f), AR("Argon", 14, 20.150f);

	private String label;
	private int atomicNumber;
	public float atomicWeight;

	private static final Map<String, EnumMultipleValues> BY_LABEL = new HashMap<>();
	private static final Map<Integer, EnumMultipleValues> BY_ATOMIC_NUMBER = new HashMap<>();
	private static final Map<Float, EnumMultipleValues> BY_ATOMIC_WEIGHT = new HashMap<>();

	private EnumMultipleValues(String label, int atomicNumber, float atomicWeight) {
		this.label = label;
		this.atomicNumber = atomicNumber;
		this.atomicWeight = atomicWeight;
	}

	static {
		for (EnumMultipleValues e : values()) {
			BY_LABEL.put(e.label, e);
			BY_ATOMIC_NUMBER.put(e.atomicNumber, e);
			BY_ATOMIC_WEIGHT.put(e.atomicWeight, e);
		}
	}

	public String getLabel() {
		return this.label;
	}

	public int getNumber() {
		return this.atomicNumber;
	}

	public float getWeight() {
		return this.atomicWeight;
	}

	public Map<String, Object> getValues() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("Label", this.label);
		m.put("Weight", this.atomicWeight);
		m.put("AtomicNo", this.atomicNumber);
		return m;
	}

	public static EnumMultipleValues valueOfLabel(String label) {
		return BY_LABEL.get(label);
	}

	public static EnumMultipleValues valueOfAtomicNumber(int number) {
		return BY_ATOMIC_NUMBER.get(number);
	}

	public static EnumMultipleValues valueOfAtomicWeight(float weight) {
		return BY_ATOMIC_WEIGHT.get(weight);
	}
}