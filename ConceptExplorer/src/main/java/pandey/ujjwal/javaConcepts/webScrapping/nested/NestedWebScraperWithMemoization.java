package pandey.ujjwal.javaConcepts.webScrapping.nested;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import pandey.ujjwal.javaConcepts.webScrapping.utlity.ScrappingUtility;

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

	public NestedWebScraperWithMemoization(String homeURLString) throws MalformedURLException, URISyntaxException { 
		super();
	    URI homeURI = new URI(homeURLString);
	    URL homeURL = homeURI.toURL();
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
				
				HttpClient client = HttpClient.newHttpClient();
		        HttpRequest request = HttpRequest.newBuilder()
			                .GET()
			                .uri(URI.create(scrapingURL))
			                .build();

		        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		        
		        String location = response.headers().firstValue("Location").orElse(scrapingURL);
		        String nestedUrlHome = new URI(location).resolve("").toString();
		        
		        if (response.statusCode() != 200 && homeURLString.equals(nestedUrlHome)) {
		            throw new IOException("Request Failed. Status Code: " + response.statusCode());
		        } else {
		        	String htmlContent = response.body();
//		        	System.out.println(htmlContent);
					if (scrapeNested) // create file for one scraping
						ScrappingUtility.writeStringToFile(htmlContent, scrapingURL);
		        }

//		        return response.body();
		        
		        
		        HttpHeaders headers = request.headers();
		        System.out.println(headers);

//				if (responseCode == 200 && homeURLString.equals(nestedUrlHome)) {
//					String inputLine;
//					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//					StringBuffer htmlContent = new StringBuffer();
//					while ((inputLine = in.readLine()) != null)
//						htmlContent.append(inputLine);
//					System.out.println(htmlContent.toString());
//					if (!scrapeNested) // create file for one scraping
//						ScrappingUtility.writeStringToFile(htmlContent.toString(), scrapingURL);
//
//					Pattern linkPattern = Pattern.compile("href=[\"'](https?://[^\"']+)");
//					Matcher linkMatcher = linkPattern.matcher(htmlContent);
//					String[] excludingKeyWords = { "wp-json", "wp-content", "googleapis", "gstatic" };
//					while (linkMatcher.find())
//						if (!ScrappingUtility.includesCheck(excludingKeyWords, linkMatcher.group(1)))
//							uniqueLinks.add(linkMatcher.group(1));
//					System.out.println("Total links found: " + uniqueLinks.size());
//					uniqueLinks.stream().forEach(System.out::println);
//				}
				
				if (scrapeNested && uniqueLinks.size() > 1)
					for (String nestedLink : uniqueLinks) {
						System.out.println("\n++++++++++ next Link ++++++++: " + nestedLink);
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