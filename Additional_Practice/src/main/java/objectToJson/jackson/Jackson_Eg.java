package objectToJson.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Jackson_Eg {
	public static void main(String[] args) {
		try {
			jacksonExample();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public static void jacksonExample() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode rootArrayNode = objectMapper.createArrayNode();

		ObjectNode classification1 = objectMapper.createObjectNode();
		classification1.put("Name", "General Information");
		classification1.put("Storage", "VectorStore");
		JsonNode subCatOfCat1 = objectMapper.readTree(
				"[\"Store Hours\", \"Contact Info\", \"Delivery Information\", \"Shipping costs\", \"Return Policy\", \"Age Verification\"]");
		classification1.putPOJO("Subcategory", subCatOfCat1);
		rootArrayNode.add(classification1);

		ObjectNode classification2 = objectMapper.createObjectNode();
		classification2.put("Name", "Product Information");
		classification2.put("Storage", "SQL");
		JsonNode subCatOfCat2 = objectMapper.readTree("[\"Product Availability\",\"Product Price\",\"Product info\"]");
		classification2.putPOJO("Subcategory", subCatOfCat2);
		rootArrayNode.add(classification2);

		ObjectNode classification3 = objectMapper.createObjectNode();
		classification3.put("Name", "Recipes");
		classification3.put("Storage", "LLM");
		JsonNode subCatOfCat3 = objectMapper.readTree("[\"Cocktail Recipes\"]");
		classification3.putPOJO("Subcategory", subCatOfCat3);
		rootArrayNode.add(classification3);

		ObjectNode classification4 = objectMapper.createObjectNode();
		classification4.put("Name", "Product Recommendations");
		classification4.put("Storage", "SQL");
		JsonNode subCatOfCat4 = objectMapper.readTree("[\"Pairing\",\"Best Sellers\",\"Gift Ideas\"]");
		classification4.putPOJO("Subcategory", subCatOfCat4);
		rootArrayNode.add(classification4);

		ObjectNode classification5 = objectMapper.createObjectNode();
		classification5.put("Name", "Customer Support");
		classification5.put("Storage", "VectorStore");
		JsonNode subCatOfCat5 = objectMapper
				.readTree("[\"Contact Information\",\"Complaints\",\"Lost Package\",\"Age Verification\"]");
		classification5.putPOJO("Subcategory", subCatOfCat5);
		rootArrayNode.add(classification5);

		String theClassificationJSONString = objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(rootArrayNode);
		System.out.println(theClassificationJSONString);
	}
}
