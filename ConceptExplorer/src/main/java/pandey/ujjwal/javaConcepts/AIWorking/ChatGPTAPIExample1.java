package pandey.ujjwal.javaConcepts.AIWorking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatGPTAPIExample1 {

	public static void main(String[] args) {
		System.out.println(chatGPT("hello, how are you? Can you tell me what's a Fibonacci Number?"));
	}

	public static String chatGPT(String prompt) {
		String url = "https://api.openai.com/v1/chat/completions";
		String apiKey = "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";
		String model = "gpt-3.5-turbo";
		try {
			// URL obj = new URL(url);
			// HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "Bearer " + apiKey);
			connection.setRequestProperty("Content-Type", "application/json");

			// The request body
			String body = """
					{1
					  "model": "%s",
					  "max_tokens": 50,
					  "messages": [{"role": "user", "content": "%s"}] }
					  """.formatted(model, prompt);
			System.out.println("Request body: " + body);
			connection.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

			writer.write(body);
			writer.flush();
			writer.close();

			// Response from ChatGPT
			StringBuffer response = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line;
			while ((line = br.readLine()) != null) {
				response.append(line);
			}
			System.out.println("Response line: " + response);
			br.close();

			// Extract the message.
			return extractMessageFromJSONResponse(response.toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public static String extractMessageFromJSONResponse(String response) {
		int start = response.indexOf("content") + 11;
		int end = response.indexOf("\"", start);
		return response.substring(start, end);
	}
}
