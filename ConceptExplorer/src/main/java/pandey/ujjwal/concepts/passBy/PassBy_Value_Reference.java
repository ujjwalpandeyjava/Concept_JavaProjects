package pandey.ujjwal.concepts.passBy;

/**
 * Pass by value works on primitive data type, and does not changes value.
 * 
 * Pass by reference works with objects, and does change value of object member
 * as updated but not work if we replace the object with new object.
 * 
 * As object work on new memory creation.
 */
public class PassBy_Value_Reference {
	public static void main(String[] args) {
		int number = 25;
		modifyValue(number);
		System.out.println(number); // Output: 25

		Person person = new Person("Ujjwal");
		modifyPerson(person);
		System.out.println(person.name); // Output: Pandey
	}

	public static void modifyValue(int value) {
		value = 10; // Not affect the original reference
	}

	public static void modifyPerson(Person p) {
		p.name = "Pandey"; // This modifies the actual object
		p = new Person("Ujjwal Pandey"); // This does not affect the original reference
	}
}

class Person {
	String name;

	Person(String name) {
		this.name = name;
	}
}