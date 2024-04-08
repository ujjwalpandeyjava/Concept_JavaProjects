package functionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import lombok.Data;

@FunctionalInterface
interface FunctionalInter {
	void print();
}

@Data
class Person {
	private String name = "Ujjwal";
}

public class ExampleMain {
	public static void main(String[] args) {

		System.out.println("\n======= Functional Interface =======");
		FunctionalInter fie = () -> System.out.println("Void print");
		fie.print();

		/**
		 * 1. Predicate: Returns boolean
		 * 2. Consumer: No return (Transform's object/dta)
		 * 3. Supplier: Object output
		 * 4. Function: Object input, & Object output (can be different types)
		 */
		
		// 1. Predicate: Returns boolean
		System.out.println("\n======= Predicate =======");
		Predicate<String> predicate = (s) -> s.length() > 3;
		System.out.println(predicate.test("Ujjwal"));
		System.out.println(predicate.test("UP"));
		
		// 2. Consumer: No return (Transform's object/dta)
		System.out.println("\n======= Consumer =======");
		Consumer<Person> consumer = (s) -> s.setName("Pandey");
		var p =  new Person();
		System.out.println(p);
		consumer.accept(p);
		System.out.println(p);
		
		// 3. Supplier: Object output
		System.out.println("\n======= function =======");
		Function<Integer, Person> function = num -> {
			var p2 = new Person();
			p2.setName(String.valueOf(num));
			return p2;
		};
		System.out.println(function.apply(100));
		
		// 4. Function: Object input, & Object output (can be different types)
		System.out.println("\n======= Supplier =======");
		Supplier<Double> supplier = () -> Math.random();
		System.out.println(supplier.get());
	}
}