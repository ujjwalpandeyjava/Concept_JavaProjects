package pandey.ujjwal.concepts.objectMapper_objectToJson;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import pandey.ujjwal.concepts.dateTime_Use.DateTime_NewWay;

public class OM_WorkingEg {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateTime_NewWay.class);

	/*
	 * POJO <--> JSON String, in simple way Can create with without POJO JSON to XML
	 */
	public static void main(String[] args) throws Exception {
		getAllActiveSchedules();
		jsonStringPojo();
	}

	public static void getAllActiveSchedules() {
		JSONObject returnObj = new JSONObject();
		List<Object> pojoList = new LinkedList<Object>();
		returnObj.put("MESSAGE", "ERROR");
		returnObj.put("DATA", pojoList);
		LOGGER.info("{}", returnObj);

		JSONArray jArray = new JSONArray("[" + returnObj.toString() + "]");
		LOGGER.info("{}", jArray);
	}

	private static void jsonStringPojo() throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		// Convert Java object to JSON
		OM_User user = new OM_User("Pandey Ji", 30);
		String json = mapper.writeValueAsString(user);
		LOGGER.info("\nJava to JSON:\n" + json);

		// Convert JSON to Java object
		// String jsonStr = "{\"name\":\"Pandey Ji\",\"age\":30}";
		OM_User user2 = mapper.readValue(json, OM_User.class);
		LOGGER.info("JSON to Java:\n" + user2);
		LOGGER.info(user2.getName() + ", " + user2.getAge());
	}
}
