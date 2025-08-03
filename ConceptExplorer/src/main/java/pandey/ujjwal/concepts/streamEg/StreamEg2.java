package pandey.ujjwal.concepts.streamEg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import io.netty.util.internal.StringUtil;

public class StreamEg2 {
	static int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	public static void main(String[] args) {
		// evenNumbers();
		// listToMap();
		// listToSalaryMapList();
		// createProject();
		flatMapExample();
	}

	private static void evenNumbers() {
		System.out.println("\nEven numbers:");
		Arrays.stream(numbers)
				.filter(n -> n % 2 == 0)
				.forEach(System.out::println);
	}

	// method to demonstrate list to map
	private static void listToMap() {
		getListOfEmployees().stream()
				.collect(Collectors.toMap(Employee::getId, n -> n.getName() + StringUtil.SPACE + n.getSalary()))
				.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
	}

	private static void listToSalaryMapList() {
		// Good way
		HashMap<Double, List<Employee>> salaryMap = new HashMap<>();
		getListOfEmployees().forEach(emp -> {
			// computeIfAbsent() checks if the key exists,
			// If not, it initializes a new list and adds emp, else adds emp.
			salaryMap.computeIfAbsent(emp.getSalary(), k -> new ArrayList<>()).add(emp);
		});
		salaryMap.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));

		System.out.println("\nUsing streams to group by salary:");
		getListOfEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getSalary))
				.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
	}

	private static List<Project> createProject() {
		Project project = new Project(1, "Project A");
		project.addTask(new Task(1, "Task 1"));
		project.addTask(new Task(2, "Task 2"));
		project.addTask(new Task(3, "Task 3"));

		Project project2 = new Project(2, "Project B");
		project2.addTask(new Task(4, "Task 4"));
		project2.addTask(new Task(5, "Task 5"));

		// System.out.println("\nProjects:");
		List<Project> projects = Arrays.asList(project, project2);
		// projects.forEach(System.out::println);
		return projects;
	}

	private static void flatMapExample() {
		List<Project> projects = createProject();
		// Example without flatMap
		System.out.println("Without FlatMap:");
		List<String> taskList = new ArrayList<>();
		for (Project project : projects) {
			for (Task task : project.getTasks()) {
				taskList.add(task.getTask());
			}
		}
		taskList.forEach(System.out::println);

		// Example with flatMap
		System.out.println("\nWith FlatMap:");
		projects.stream()
				.flatMap(p -> p.getTasks().stream())
				.map(Task::getTask)
				.collect(Collectors.toList())
				.forEach(System.out::println);
	}

	// Utils

	private static List<Employee> getListOfEmployees() {
		List<Employee> empList = Arrays.asList(
				new Employee(1, "Ujjwal", 30, 50000),
				new Employee(2, "Shyam", 28, 48000),
				new Employee(3, "Ujjwal", 32, 52000),
				new Employee(4, "Mohan", 25, 45000),
				new Employee(5, "Sita", 29, 47000),
				new Employee(6, "Gita", 31, 51000),
				new Employee(7, "Shyam", 27, 46000),
				new Employee(8, "Ujjwal", 30, 50000),
				new Employee(9, "Mohan", 25, 45000),
				new Employee(10, "Rita", 30, 49000),
				new Employee(11, "Gita", 33, 53000),
				new Employee(12, "Anita", 26, 44000));
		return empList;
	}
}

// Create class Task having id and task.
class Task {
	private int id;
	private String task;

	public Task(int id, String task) {
		this.id = id;
		this.task = task;
	}

	public int getId() {
		return id;
	}

	public String getTask() {
		return task;
	}

	@Override
	public String toString() {
		return "Task{id=" + id + ", task='" + task + "'}";
	}
}

// Create class Project having id, name, and list of Tasks class.
class Project {
	private int id;
	private String name;
	private List<Task> tasks;

	public Project(int id, String name) {
		this.id = id;
		this.name = name;
		this.tasks = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	@Override
	public String toString() {
		return "Project{id=" + id + ", name='" + name + "', tasks=" + tasks + "}";
	}
}