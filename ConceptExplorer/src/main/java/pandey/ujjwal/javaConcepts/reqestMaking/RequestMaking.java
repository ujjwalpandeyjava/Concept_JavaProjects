package pandey.ujjwal.javaConcepts.reqestMaking;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestMaking {
	public static void main(String[] args) {
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("https://pokeapi.co/api/v2/pokemon/ditto")).headers("","").build();
		try {
			HttpResponse<String> send = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());
			System.out.println(send.statusCode());
			if (send.statusCode() == 200) {
				System.out.println(send.body());
			} else System.out.println("issue ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
