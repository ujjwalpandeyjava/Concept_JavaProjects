package objectToJson.gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dbExample.conn.DatabaseConnector;
import objectToJson.POJO;

/*
  	Gson gson = new Gson();
 	POJO -> JSON String
	String json = gson.toJson(new User(1, "Lokesh"));
	JSON String -> POJO 
	User user = gson.fromJson(json, User.class);
	
	Using builder to override the default configuration (hard to use)
	Gson gson = new GsonBuilder()
     .registerTypeAdapter(POJO.class, new IdTypeAdapter())
     .enableComplexMapKeySerialization()
     .serializeNulls()
     .setDateFormat(DateFormat.LONG)
     .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
     .setPrettyPrinting()
     .setVersion(1.0)
     .create();
 */

public class GSON_EG {
	public static String getAllActiveSchedules() throws SQLException {
		Gson returnObj = new GsonBuilder().setPrettyPrinting().create();
		
		List<POJO> pojoList = new LinkedList<POJO>();
		// Create a Map to represent key-value pairs
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("name", "John Doe");
		jsonMap.put("age", 30);
		jsonMap.put("status", "working"); // Dynamically add a new field
		String jsonString = returnObj.toJson(jsonMap);
		System.out.println(jsonString);

		jsonMap.put("MESSAGE", "ERROR");
		jsonMap.put("DATA", "");

		String sqlCMDAll = "SELECT * FROM future_scheduled WHERE willRun = ?";
		Connection conn = DatabaseConnector.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sqlCMDAll);
		pstmt.setBoolean(1, false);

		ResultSet allSchedulables = pstmt.executeQuery();
		while (allSchedulables.next()) {
			long id = allSchedulables.getLong("id");
			String stringVal = allSchedulables.getString("emailTemplate");
			int intVal = allSchedulables.getInt("fromIndex");
			boolean boolVal = allSchedulables.getBoolean("willRun");
			Timestamp dateTimeVal = allSchedulables.getTimestamp("futureDateTime");
			POJO efs = new POJO(stringVal, id, intVal, boolVal, dateTimeVal);
			pojoList.add(efs);
		}
		System.out.println("futureCampaignList size: " + pojoList.size());
		jsonMap.put("TOTAL", pojoList.size());
		jsonMap.put("MESSAGE", "SUCCESS");
		jsonMap.put("DATA", pojoList);
		jsonString = returnObj.toJson(jsonMap);
		return jsonString;
	}
}
