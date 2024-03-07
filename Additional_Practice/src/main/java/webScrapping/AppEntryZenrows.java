package webScrapping;

import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.Base64;

//import java.util.concurrent.Executor;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.hc.client5.http.fluent.Executor;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.core5.http.HttpHost;

public class AppEntryZenrows {
	public static void main(final String... args) throws Exception {
		ignoreCertWarning();

		String urlToScrape = "https://aionscheduler.com/";
		URI uri = new URI("http://3398fc6a0fa4a9d898fce95f9f98089989bd92db:@proxy.zenrows.com:8001");

		String[] userInfo = uri.getUserInfo().split(":", 2);
		String user = userInfo[0];
		String pass = userInfo[1];
		String basicAuth = new String(Base64.getEncoder().encode(uri.getUserInfo().getBytes()));
		String response = Executor.newInstance()
				.auth(new HttpHost(uri.getHost(), uri.getPort()), user, pass.toCharArray())
				.authPreemptiveProxy(new HttpHost(uri.getHost(), uri.getPort())).execute(Request.get(urlToScrape)
						.addHeader("Proxy-Authorization", "Basic " + basicAuth).viaProxy(HttpHost.create(uri)))
				.returnContent().asString();

		System.out.println(response);
	}

	private static void ignoreCertWarning() {
		SSLContext ctx = null;
		TrustManager[] trustAllCerts = new X509TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };

		try {
			ctx = SSLContext.getInstance("SSL");
			ctx.init(null, trustAllCerts, null);
			SSLContext.setDefault(ctx);
		} catch (Exception e) {
		}
	}
}