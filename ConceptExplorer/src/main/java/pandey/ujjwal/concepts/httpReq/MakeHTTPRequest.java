package pandey.ujjwal.concepts.httpReq;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MakeHTTPRequest {
	public static void main(String[] args) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://picsum.photos/v2/list?page=1&limit=10"))
				.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.statusCode());
		System.out.println(response.body());
	}
}
