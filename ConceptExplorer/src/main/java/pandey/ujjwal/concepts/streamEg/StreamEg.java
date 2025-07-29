package pandey.ujjwal.concepts.streamEg;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamEg {
	static List<Employee> empList = Arrays.asList(
			new Employee("Ujjwal", 30, 50000),
			new Employee("Shyam", 28, 48000),
			new Employee("Ujjwal", 32, 52000),
			new Employee("Mohan", 25, 45000),
			new Employee("Sita", 29, 47000),
			new Employee("Gita", 31, 51000),
			new Employee("Shyam", 27, 46000),
			new Employee("Ujjwal", 30, 50000),
			new Employee("Mohan", 25, 45000),
			new Employee("Rita", 30, 49000),
			new Employee("Gita", 33, 53000),
			new Employee("Anita", 26, 44000));

	public static void main(String[] args) {
		fromArray();
		getFrequency();
	}

	private static void fromArray() {
		String[] array = { "One", "Two", "Three", "Four", "Five" };

		List<String> listFromStream = Arrays.stream(array).collect(Collectors.toList());
		System.out.println("List from array: " + listFromStream);

		Map<Object, Object> mapFromArray = Arrays.stream(array)
				.collect(Collectors.toMap(Arrays::asList, i -> i, (a, b) -> b));
		System.out.println("Map from array: " + mapFromArray);
	}

	private static void getFrequency() {
		System.out.println("\nGet Distinct Employee Names");
		List<String> empNames = empList.stream()
				.filter(Objects::nonNull)
				.map(Employee::getName)
				.filter(Objects::nonNull)
				.distinct()
				.collect(Collectors.toList());
		System.out.println(empNames);

		System.out.println("\nFrequency of Names");
		Map<String, Long> nameFrequency = empList.stream()
				.filter(Objects::nonNull)
				.map(Employee::getName)
				.filter(Objects::nonNull)
				.collect(Collectors.groupingBy(
						Function.identity(),
						Collectors.counting()));
		System.out.println(nameFrequency);

		System.out.println("\nCollectors.toMap() for Frequency Count");
		Map<String, Long> nameFrequency2 = empList.stream()
				.filter(Objects::nonNull)
				.map(Employee::getName)
				.filter(Objects::nonNull)
				.collect(Collectors.toMap(
						name -> name, // key: name
						name -> 1L, // initial count
						Long::sum // merge function: sum duplicates
				));
		System.out.println(nameFrequency2);
		// nameFrequency2.forEach((k, v) -> System.out.println(k + " → " + v));

		System.out.println("\nCollect to Map: Name");
		Map<String, Employee> nameToEmpMap = empList.stream()
				.filter(Objects::nonNull)
				.filter(e -> e.getName() != null)
				.collect(Collectors.toMap(
						Employee::getName,
						Function.identity(), // Full object
						(existing, replacement) -> existing
				// If names can repeat, use toMap(..., (a,b) -> a) to resolve conflicts
				));
		System.out.println(nameToEmpMap);
		// nameToEmpMap.forEach((k, v) -> System.out.println(k + " → " + v));

	}

}

class Employee {
	private String name;
	private int age;
	private double salary;

	// Constructor, Getters
	public Employee(String name, int age, double salary) {
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

	@Override
	public String toString() {
		return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
	}
}