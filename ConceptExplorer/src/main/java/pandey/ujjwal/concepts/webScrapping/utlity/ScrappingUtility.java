package pandey.ujjwal.concepts.webScrapping.utlity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ScrappingUtility {

	public static boolean includesCheck(String[] valuesToCheck, String inputString) {
		boolean containsValue = false;
		for (String value : valuesToCheck)
			if (inputString.contains(value)) {
				containsValue = true;
				break;
			}
		return containsValue;
	}

	public static void writeStringToFile(String content, String scrapingURL) {
		String hostName = "unknown";
		System.out.println(content);
		System.out.println(scrapingURL);

		try {
			URI ur = new URI(scrapingURL);
			hostName = ur.getHost();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		String fileName = hostName + "_webPage";
		String filePath = "./codeUploads/" + fileName + ".txt";
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
