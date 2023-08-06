package utility.requestProcessor;
/* 
 * Cert: Certificate (SSL Certificate)
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpRequestProcessor {
	HttpRequestProcessor() {
	}

	HttpRequestProcessor(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		System.setProperty("SSL_CERTIFICATE_FILE_PATH", "/NFSet");
		System.out.println(System.getenv().getOrDefault("SSL_CERTIFICATE_FILE_PATH", "SSL_CERTIFICATE_FILE_PATH: __"));	// Set manually or use file path system
//		System.out.println(System.getenv().getOrDefault("TEMP", "NF"));	// Working as it is already set.
		Log.debug("Sending HTTP '%s' request to URL ==>%s", "reqMethod", "url");
	}

	private static final String USER_AGENT = "Mozilla/5.0";

	/**
	 * Function to send HTTP request
	 * 
	 * @param String URL
	 * @param String Request Method (POST/GET/PUT/DELETE)
	 * @param String authorization Header (Optional)
	 * @return String response
	 **/
	public static String sendHttpRequest(String urlWithParam, String reqMethod, String authHeader) {
		StringBuffer response = new StringBuffer();
		try {
			URL url = new URL(urlWithParam);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod(reqMethod); // (POST/GET/PUT/DELETE)

			/*------------Adding Request Header-------*/
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			if (authHeader != null && authHeader.length() > 0)
				con.setRequestProperty("Authorization", authHeader);

			int responseCode = con.getResponseCode();

			Log.debug("Sending HTTP '%s' request to URL ==>%s", reqMethod, url);
			Log.debug("HTTP '%s' Response Code ==>%s", reqMethod, responseCode);

			if (responseCode >= 200 && responseCode < 300) {
				// HTTP SUCCESS CODE RANGE IS FROM 200 TO 299
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				in.close();
			} else
				Log.error("Request cannot be processed successfully. Returned http response code=>%d", responseCode);
		} catch (Exception e) {
			Log.fatal("Exception during send HTTP '%s' request, ERROR=>%s", reqMethod, e.getMessage());
			e.printStackTrace();
		}

		return response.toString();
	}

	/**
	 * Function to send HTTP Post request
	 * 
	 * @param String URL
	 * @param String URL parameters
	 * @param String Request Method (POST/GET/PUT/DELETE)
	 * @param String authorization Header (Optional)
	 * @return String response
	 **/
	public static String sendHttpRequest(String url, String urlParameters, String reqMethod, String authHeader) {
		StringBuffer response = new StringBuffer();
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod(reqMethod); // (POST/GET/PUT/DELETE)

			/*------------Adding Request Header-------*/
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			if (authHeader != null && authHeader.length() > 0)
				con.setRequestProperty("Authorization", authHeader);

			con.setDoOutput(true);

			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();

			Log.debug("Sending 'POST' request to URL ==>%s", url);
			Log.debug("'POST' request Parameters ==>%s", urlParameters);
			Log.debug("HTTP 'POST' Response Code  ==>%s", responseCode);

			if (responseCode >= 200 && responseCode < 300) // HTTP SUCCESS CODE RANGE IS FROM 200 TO 299
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				in.close();
			} else
				Log.error("Request cannot be processed successfully. Returned http response code=>%d", responseCode);
		} catch (Exception e) {
			Log.fatal("Exception during send HTTP Post request, ERROR=>%s", e.getMessage());
			e.printStackTrace();
		}

		return response.toString();
	}

	/**
	 * Function to send HTTP request with Content-Type JSON
	 * 
	 * @param String        URL
	 * @param String        JSONText
	 * @param requestMethod (POST/GET/PUT/DELETE)
	 * @param String        authorization Header (Optional)
	 * @return String Response
	 * @throws IOException
	 **/
	public static String sendHttpRequestWithJson(String url, String jsonText, String requestMethod, String authHeader)
			throws IOException {
		StringBuffer response = new StringBuffer();
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod(requestMethod); // (POST/GET/PUT/DELETE)

		/*------------Adding Request Header-------*/
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "application/json");

		if (authHeader != null && authHeader.length() > 0)
			con.setRequestProperty("Authorization", authHeader);

		con.setDoOutput(true);

		/*------------Sending request ---------------*/
		OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
		out.write(jsonText);
		out.close();

		int responseCode = con.getResponseCode();

		Log.debug("Sending 'POST' request to URL ==>%s", url);
		Log.debug("HTTP 'POST' Response Code  ==>%s", responseCode);

		if (responseCode >= 200 && responseCode < 300) // HTTP SUCCESS CODE RANGE IS FROM 200 TO 299
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();
		} else
			Log.error("Request cannot be processed successfully. Returned http response code=>%d", responseCode);

		return response.toString();
	}

	/**
	 * This function is responsible to send HTTPS request with JSON
	 * 
	 * @param url
	 * @param jsonText
	 * @param requestMethod (POST/GET/PUT/DELETE)
	 * @param authHeader    (Optional)
	 * @param isReqWithCert
	 * @param headers
	 * @return
	 * @throws IOException
	 */
	public static String sendHttpsRequestWithJson(String url, String jsonText, String requestMethod, String authHeader,
			boolean isReqWithCert, Properties headers) throws IOException {
		URL obj = new URL(url);

		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setRequestMethod(requestMethod); // (POST/GET/PUT/DELETE)
		con.setRequestProperty("Content-length", String.valueOf(jsonText.length()));
		con.setRequestProperty("Content-Type", "application/json");

		if (authHeader != null && authHeader.length() > 0)
			con.setRequestProperty("Authorization", authHeader);

		/*---------------ADD HEADERS-----------------------------*/
		if (headers != null && headers.size() > 0) {
			for (Object key : headers.keySet()) {
				con.setRequestProperty((String) key, headers.getProperty((String) key));
			}
		}
		/*-----------------------------------------------------------*/

		con.setDoOutput(true);

		SSLSocketFactory sslSocketFactory = (isReqWithCert) ? createSSLSocketFactoryWithCert()
				: createSSLSocketFactory();
		con.setSSLSocketFactory(sslSocketFactory);

		OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
		out.write(jsonText);
		out.close();

		int responseCode = con.getResponseCode();

		Log.debug("Sending HTTPS 'POST' request to URL ==>%s", url);
		Log.debug("HTTPS 'POST' Response Code ==>%s", responseCode);

		if (responseCode >= 200 && responseCode < 300) // HTTP SUCCESS CODE RANGE IS FROM 200 TO 299
		{
			StringBuffer response = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();

			return response.toString();
		} else
			Log.error("Request cannot be processed successfully. Returned http response code=>%d", responseCode);

		return null;
	}

	/**
	 * This function is responsible to send HTTP request
	 * 
	 * @param url
	 * @param reqMethod     (POST/GET/PUT/DELETE)
	 * @param authHeader    (Optional)
	 * @param contentType
	 * @param isReqWithCert
	 * @param headers
	 * @return
	 */
	public static String sendHttpsRequest(String url, String reqMethod, String authHeader, String contentType,
			boolean isReqWithCert, Properties headers) {
		StringBuffer response = new StringBuffer();
		try {
			Log.debug("sendHttpsRequest..........");
			URL obj = new URL(url);

			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			con.setRequestMethod(reqMethod); // (POST/GET/PUT/DELETE)

			SSLSocketFactory sslSocketFactory = (isReqWithCert) ? createSSLSocketFactoryWithCert()
					: createSSLSocketFactory();

			con.setSSLSocketFactory(sslSocketFactory);
			if (contentType != null && contentType.length() > 0)
				con.setRequestProperty("Content-Type", contentType);
			con.setRequestProperty("Accept", "application/json");

			if (authHeader != null && authHeader.length() > 0)
				con.setRequestProperty("Authorization", authHeader);

			/*---------------ADD HEADERS-----------------------------*/
			if (headers != null && headers.size() > 0) {
				for (Object key : headers.keySet()) {
					con.setRequestProperty((String) key, headers.getProperty((String) key));
				}
			}
			/*-----------------------------------------------------------*/

			int responseCode = con.getResponseCode();

			Log.debug("Sending HTTPS '%s' request to URL ==>%s", reqMethod, url);
			Log.debug("HTTPS '%s' Response Code ==>%s", reqMethod, responseCode);

			if (responseCode >= 200 && responseCode < 300) // HTTP SUCCESS CODE RANGE IS FROM 200 TO 299
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				in.close();
			} else
				Log.error("Request cannot be processed successfully. Returned http response code=>%d", responseCode);
		} catch (Exception e) {
			Log.fatal("Exception during send HTTPS '%s' request, ERROR=>%s", reqMethod, e.getMessage());
			e.printStackTrace();
		}

		return response.toString();
	}

	/**
	 * This function is responsible to send HTTPS request
	 * 
	 * @param url
	 * @param reqMethod
	 * @param authHeader
	 * @param contentType
	 * @param isReqWithCert
	 * @param headers
	 * @return
	 */
	public static InputStream sendHttpsRequestAndGetInputStream(String url, String reqMethod, String authHeader,
			String contentType, boolean isReqWithCert, Properties headers) {
		try {
			URL obj = new URL(url);

			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			con.setRequestMethod(reqMethod); // (POST/GET/PUT/DELETE)

			SSLSocketFactory sslSocketFactory = (isReqWithCert) ? createSSLSocketFactoryWithCert()
					: createSSLSocketFactory();

			con.setSSLSocketFactory(sslSocketFactory);
			if (contentType != null && contentType.length() > 0)
				con.setRequestProperty("Content-Type", contentType);
			con.setRequestProperty("Accept", "application/json");

			if (authHeader != null && authHeader.length() > 0)
				con.setRequestProperty("Authorization", authHeader);

			/*---------------ADD HEADERS-----------------------------*/
			if (headers != null && headers.size() > 0) {
				for (Object key : headers.keySet())
					con.setRequestProperty((String) key, headers.getProperty((String) key));
			}
			/*-----------------------------------------------------------*/

			int responseCode = con.getResponseCode();

			Log.debug("Sending HTTPS '%s' request to URL ==>%s", reqMethod, url);
			Log.debug("HTTPS '%s' Response Code ==>%s", reqMethod, responseCode);

			if (responseCode >= 200 && responseCode < 300) // HTTP SUCCESS CODE RANGE IS FROM 200 TO 299
			{
				return con.getInputStream();
			} else
				Log.error("Request cannot be processed successfully. Returned http response code=>%d", responseCode);
		} catch (Exception e) {
			Log.fatal("Exception during send HTTPS '%s' request, ERROR=>%s", reqMethod, e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Send HTTPS request with parameters
	 * 
	 * @param url           to hit
	 * @param params        to add in request
	 * @param reqMethod     can be: POST/GET/PUT/DELETE/etc
	 * @param authHeader    (Optional)
	 * @param contentType
	 * @param isReqWithCert
	 * @param headers
	 * @return String response from the uri hit
	 */
	public static String sendHttpsRequest(String url, String params, String reqMethod, String authHeader,
			String contentType, boolean isReqWithCert, Properties headers) {
		StringBuffer response = new StringBuffer();
		try {
			URL obj = new URL(url);

			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			con.setRequestMethod(reqMethod); // (POST/GET/PUT/DELETE)

			SSLSocketFactory sslSocketFactory = (isReqWithCert) ? createSSLSocketFactoryWithCert()
					: createSSLSocketFactory();
			con.setSSLSocketFactory(sslSocketFactory);

			if (contentType != null && contentType.length() > 0)
				con.setRequestProperty("Content-Type", contentType);
			if (authHeader != null && authHeader.length() > 0)
				con.setRequestProperty("Authorization", authHeader);
			con.setRequestProperty("Accept", "application/json");

			/*---------------ADD HEADERS-----------------------------*/
			if (headers != null && headers.size() > 0) {
				for (Object key : headers.keySet()) {
					con.setRequestProperty((String) key, headers.getProperty((String) key));
				}
			}
			/*-----------------------------------------------------------*/

			con.setDoOutput(true);

			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(params);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();

			Log.debug("Sending HTTPS '%s' request to URL ==>%s", reqMethod, url);
			Log.debug("HTTPS '%s' Response Code ==>%s", reqMethod, responseCode);

			if (responseCode >= 200 && responseCode < 300) // HTTP SUCCESS CODE RANGE IS FROM 200 TO 299
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
				String inputLine;
				while ((inputLine = in.readLine()) != null)
					response.append(inputLine);
				in.close();
			} else
				Log.error("Request cannot be processed successfully. Returned http response code=>%d", responseCode);
		} catch (Exception e) {
			Log.fatal("Exception during send HTTPS '%s' request, ERROR=>%s", reqMethod, e.getMessage());
			e.printStackTrace();
		}

		return response.toString();
	}

	/**
	 * @return SSLSocketFactory instance for secure https connection
	 **/
	public static SSLSocketFactory createSSLSocketFactory() {
		try {
			SSLContext context = SSLContext.getInstance("SSL");
			context.init(null, new TrustManager[] { new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] x509Certificates, String authType)
						throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] x509Certificates, String authType)
						throws CertificateException {
					Log.debug("Got the certificate...");
				}

				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}
			} }, new SecureRandom());

			return context.getSocketFactory();
		} catch (NoSuchAlgorithmException e) {
			throw new Error(e);
		} catch (KeyManagementException e) {
			throw new Error(e);
		}
	}

	/**
	 * @return SSLSocketFactory from SSL certificate file
	 */
	public static SSLSocketFactory createSSLSocketFactoryWithCert() {
		try {
			String certPath = System.getenv("SSL_CERTIFICATE_FILE_PATH"); // Path of SSL Certificate

			FileInputStream certIn = new FileInputStream(new File(certPath));
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			ks.load(certIn, "a568Pqt".toCharArray());
			kmf.init(ks, "a568Pqt".toCharArray());

			SSLContext sslContext = SSLContext.getInstance("SSL");
			sslContext.init(kmf.getKeyManagers(), null, null);

			certIn.close();

			return sslContext.getSocketFactory();
		} catch (Exception e) {
			Log.fatal("Exception during createSSLSocketFactory with certificate. ERROR=>%s", e.toString());
			e.printStackTrace();
			return null;
		}
	}

	// The real log is: https://www.javatpoint.com/log4j
	// This is: Inner class
	static class Log {
		static void debug(Object... values) {
			for (Object c : values)
				System.out.println(c);
		}

		static void error(Object... values) {
			debug(values);
		}

		static void fatal(Object... values) {
			debug(values);
		}
	}
}
