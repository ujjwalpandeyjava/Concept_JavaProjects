package pandey.ujjwal.javaConcepts.webScrapping.nested;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class AppEntryNestedWebScrapping {

	public static void main(String[] args) throws IOException {
		String siteHomeURL = "https://ujjwalpandeyjava.github.io/Portfolio/";
		
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Enter URL: ");
			siteHomeURL = scan.nextLine();
			var nestedWebScrape = new NestedWebScraperWithMemoization(siteHomeURL);
			nestedWebScrape.nestedScrape(siteHomeURL, true);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}