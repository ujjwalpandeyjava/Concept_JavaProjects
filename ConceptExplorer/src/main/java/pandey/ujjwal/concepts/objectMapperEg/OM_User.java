package pandey.ujjwal.concepts.objectMapperEg;

public class OM_User {
	private String name;
	private int age;

	// Constructors
	public OM_User() {
	}

	public OM_User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// toString method
	@Override
	public String toString() {
		return "OM_User{name='" + name + "', age=" + age + '}';
	}
}
