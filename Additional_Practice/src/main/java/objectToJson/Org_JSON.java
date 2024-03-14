package objectToJson;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Org_JSON {

	/*
	 * POJO <--> JSON String, in simple way Can create with without POJO JSON to XML
	 */
	public static void main(String[] args) {
		getAllActiveSchedules();
	}

	public static void getAllActiveSchedules() {
		JSONObject returnObj = new JSONObject();
		List<Object> pojoList = new LinkedList<Object>();
		returnObj.put("MESSAGE", "ERROR");
		returnObj.put("DATA", pojoList);
		System.out.println(returnObj);

		JSONArray jArray = new JSONArray("[" + returnObj.toString() + "]");
		System.out.println(jArray);

	}
}
