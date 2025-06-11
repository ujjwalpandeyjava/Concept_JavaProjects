package pandey.ujjwal.concepts.objectMapperEg;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperExample {
	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		// Convert Java object to JSON
		OM_User user = new OM_User("Pandey Ji", 30);
		String json = mapper.writeValueAsString(user);
		System.out.println("\nJava to JSON:\n" + json);

		// Convert JSON to Java object
		// String jsonStr = "{\"name\":\"Pandey Ji\",\"age\":30}";
		OM_User user2 = mapper.readValue(json, OM_User.class);
		System.out.println("JSON to Java:\n" + user2);
		System.out.println(user2.getName() + ", " + user2.getAge());
	}
}
