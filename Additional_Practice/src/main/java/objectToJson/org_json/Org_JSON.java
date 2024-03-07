package objectToJson.org_json;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import dbExample.conn.DatabaseConnector;
import objectToJson.POJO;

public class Org_JSON {
	public static JSONObject getAllActiveSchedules() throws SQLException {
		JSONObject returnObj = new JSONObject();
		List<POJO> pojoList = new LinkedList<POJO>();
		returnObj.put("MESSAGE", "ERROR");
		returnObj.put("DATA", "");

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
		returnObj.put("TOTAL", pojoList.size());
		JSONArray jsonArray = new JSONArray(pojoList);
		returnObj.put("MESSAGE", "SUCCESS");
		returnObj.put("DATA", jsonArray);
		return returnObj;
	}
}
