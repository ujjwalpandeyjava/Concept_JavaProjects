package webScrapping.nested;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import webScrapping.utlity.ScrappingUtility;

public class NestedWebScraperWithMemoization {
	private String homeURLString;
	private Map<String, Boolean> memo = new HashMap<>();
	Set<String> uniqueLinks = new TreeSet<>();

	public void setHomeURLString(String homeURLString) {
		this.homeURLString = homeURLString;
	}

	public NestedWebScraperWithMemoization() {
		super();
	}

	public NestedWebScraperWithMemoization(String homeURLString) throws MalformedURLException {
		super();
		URL homeURL = new URL(homeURLString);
		String home = homeURL.getProtocol() + "://" + homeURL.getHost();
		System.out.println("Home URL: " + home);
		this.homeURLString = home;
	}

	public Boolean nestedScrape(String scrapingURL, boolean scrapeNested) throws IOException {
		if (memo.containsKey(scrapingURL)) {
			System.out.println("\nAlready Scrapped: " + scrapingURL);
			return memo.get(scrapingURL);
		} else {
			System.out.println("\nNew Scrapping: " + scrapingURL);
			memo.put(scrapingURL, true);
			try {
				URL url = new URL(scrapingURL);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.connect();
				int responseCode = con.getResponseCode();
				String nestedUrlHome = url.getProtocol() + "://" + url.getHost();

				System.out.println("code: " + responseCode + " | Same home: " + homeURLString.equals(nestedUrlHome));
				if (responseCode == 200 && homeURLString.equals(nestedUrlHome)) {
					String inputLine;
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					StringBuffer htmlContent = new StringBuffer();
					while ((inputLine = in.readLine()) != null)
						htmlContent.append(inputLine);
					System.out.println(htmlContent.toString());
					if (!scrapeNested) // create file for one scraping
						ScrappingUtility.writeStringToFile(htmlContent.toString(), scrapingURL);

					Pattern linkPattern = Pattern.compile("href=[\"'](https?://[^\"']+)");
					Matcher linkMatcher = linkPattern.matcher(htmlContent);
					String[] excludingKeyWords = { "wp-json", "wp-content", "googleapis", "gstatic" };
					while (linkMatcher.find())
						if (!ScrappingUtility.includesCheck(excludingKeyWords, linkMatcher.group(1)))
							uniqueLinks.add(linkMatcher.group(1));
					System.out.println("Total links found: " + uniqueLinks.size());
					uniqueLinks.stream().forEach(System.out::println);
				} else {
					System.out.println("Error: " + responseCode);
				}
				if (scrapeNested && uniqueLinks.size() > 1)
					for (String nestedLink : uniqueLinks) {
						System.out.println("\n++++++++++ next Link ++++++++");
						System.out.println(nestedLink);
						nestedScrape(nestedLink, scrapeNested);
					}
			} catch (Exception e) {
				memo.put(scrapingURL, true);
				e.printStackTrace();
			}
			return true;
		}
	}
}