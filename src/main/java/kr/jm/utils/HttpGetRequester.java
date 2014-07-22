package kr.jm.utils;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpGetRequester {

	public static String getResponseAsString(String url) {
		String response = null;
		try {
			response = getResponseAsStringThrowsEx(url);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return response;
	}

	private static String getResponseAsStringThrowsEx(String url)
			throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(httpGet);
		String responseString = null;
		try {
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new IllegalStateException(response.getStatusLine()
						.getStatusCode()
						+ " "
						+ response.getStatusLine().getReasonPhrase());
			} else {
				responseString = IOUtils.toString(entity.getContent());
			}
			EntityUtils.consume(entity);
		} finally {
			response.close();
		}
		return responseString;
	}
}
