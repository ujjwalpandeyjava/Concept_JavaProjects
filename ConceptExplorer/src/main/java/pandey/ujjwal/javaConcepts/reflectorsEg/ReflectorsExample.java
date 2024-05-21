package pandey.ujjwal.javaConcepts.reflectorsEg;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lombok.Data;

public class ReflectorsExample {

	public static void main(String[] args) {
		Plan plan = new Plan();
		System.out.println(plan);
		Class<? extends Plan> class1 = plan.getClass();
		Field[] declaredFields = class1.getDeclaredFields();
		for (Field field2 : declaredFields)
			System.out.println(field2.getName());
		System.out.println("______");
		Method[] declaredMethods = class1.getDeclaredMethods();
		for (Method m : declaredMethods)
			System.out.println(m.getName());
		System.out.println("______");

		try {
			plan.setName("Ujjwal Pandey");
			Method d2 = class1.getDeclaredMethod("getName"); // Method with [...parameters]
			if (d2.canAccess(plan))
				System.out.println(d2.invoke(plan));
			else
				System.out.println("Cannot access the method 'getName'");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

}

@Data
class Plan {
	private String name;
}
