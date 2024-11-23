package pandey.ujjwal.javaConcepts.webScrapping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebScraper {
	public static void main(String[] args) throws Exception {
		String url = "https://aionscheduler.com/";
		String TextToSearch = "home";

		// Create a connection to the website
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.connect();
		int responseCode = con.getResponseCode();
		System.out.println("Connection stablished!\n" + responseCode);

		// Check for success response
		if (responseCode == 200) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer html = new StringBuffer();
			while ((inputLine = in.readLine()) != null)
				html.append(inputLine);
			WriteStringToFile(html.toString());

			System.out.println("+++++++++++++++++++++++++++++++++");

			int classCount = 0;
			Pattern p1 = Pattern.compile(TextToSearch);
			Matcher matcher = p1.matcher(html);
			while (matcher.find()) {
				classCount++;
				System.out.print(matcher.group() + " | ");
			}
			System.out.println("\nCount of text '" + TextToSearch + "': " + classCount);
		} else {
			System.out.println("Error: " + responseCode);
		}
	}

	public static void WriteStringToFile(String content) {
		System.out.println(content);
		String fileName = "webPage";
		String filePath = "src/main/java/webScrapping/" + fileName + ".txt";
		String fileExtension = ".html";
		try {
			FileWriter fileWriter = new FileWriter(filePath); // Create a FileWriter with the desired file path
			fileWriter.write(content); // Write the content to the file
			fileWriter.close(); // Close the FileWriter
			DeleteFile(filePath.replace(".txt", fileExtension));
			String newFilePath = filePath.replace(".txt", fileExtension);
			boolean renamed = new java.io.File(filePath).renameTo(new java.io.File(newFilePath));
			System.out.println((renamed) ? "File renamed successfully." : "Failed to rename the file.");
		} catch (IOException e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
	}

	public static void DeleteFile(String filePath_NameWithExtension) {
		System.out.println(filePath_NameWithExtension);
		// Create a File object with the specified file path
		File fileToDelete = new File(filePath_NameWithExtension);
		if (fileToDelete.exists()) { // Trying to delete file
			System.out.println(fileToDelete.delete() ? "File deleted successfully." : "Failed to delete the file.");
		} else
			System.err.println("The file does not exist.");
	}
}