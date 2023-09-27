package webScrapping.nested;

import java.io.IOException;
import java.util.Scanner;

public class AppEntryNestedWebScrapping {

	public static void main(String[] args) throws IOException {
		String siteHomeURL = "https://aionscheduler.com/";
//		String siteHomeURL = "https://www.homedepot.ca/en/home/categories/building-materials/lumber-and-composites/boards-planks-and-panels/appearance-boards-and-planks.html";
//		String siteHomeURL = "https://www.croma.com/";
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Enter URL: ");
			siteHomeURL = scan.nextLine();
			var nestedWebScrape = new NestedWebScraperWithMemoization(siteHomeURL);
			nestedWebScrape.nestedScrape(siteHomeURL, true);
		}
	}
}