package zzOthers;

import java.sql.SQLException;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import exceptions.customException.CustomException;
import objectToJson.gson.GSON_EG;
import objectToJson.jackson.Jackson_Eg;
import objectToJson.org_json.Org_JSON;

public class Testings {
	public static void main(String[] args) throws SQLException {
//		try {
//			CustomException.ValidateAge(9);
//		} catch (Exception e) {	
//			System.out.println("Exception fires here ....\n" + e);
//		}
//		JSONObject allActiveSchedules = Org_JSON.getAllActiveSchedules();
//		System.out.println(allActiveSchedules.toString());
		
//		String stringReturn = GSON_EG.getAllActiveSchedules();
//		System.out.println(stringReturn);
		
		try {
			Jackson_Eg.jacksonExample();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
