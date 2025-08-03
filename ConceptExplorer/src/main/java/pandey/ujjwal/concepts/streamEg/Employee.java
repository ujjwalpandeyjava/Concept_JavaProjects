package pandey.ujjwal.concepts.streamEg;

public class Employee {
	private int id;
	private String name;
	private int age;
	private double salary;

	public Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Employee(int id, String name, int age, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getSalary() {
		return salary;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee{id=" + id + ", name='" + name + "', age=" + age + ", salary=" + salary + "}";
	}
}