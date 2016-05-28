package kr.jm.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.type.TypeReference;

import kr.jm.utils.exception.JMExceptionManager;
import kr.jm.utils.helper.JMIO;
import kr.jm.utils.helper.JMJson;
import kr.jm.utils.helper.JMString;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class HttpGetRequester.
 */
@Slf4j
public class HttpGetRequester {

	/**
	 * Gets the rest api response as object.
	 *
	 * @param <T>
	 *            the generic type
	 * @param url
	 *            the url
	 * @param typeReference
	 *            the type reference
	 * @return the rest api response as object
	 */
	public static <T> T getRestApiResponseAsObject(String url,
			TypeReference<T> typeReference) {
		try {
			return JMJson.fromJsonString(getResponseAsStringThrowsEx(url),
					typeReference);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"getRestApiResponseAsObject", url, typeReference);
		}
	}

	/**
	 * Gets the response as string.
	 *
	 * @param url
	 *            the url
	 * @return the response as string
	 */
	public static String getResponseAsString(String url) {
		try {
			return getResponseAsStringThrowsEx(url);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"getResponseAsString", url);
		}
	}

	private static String getResponseAsStringThrowsEx(String url)
			throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		String responseString = null;
		try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new IllegalStateException(
						response.getStatusLine().getStatusCode()
								+ JMString.SPACE
								+ response.getStatusLine().getReasonPhrase());
			} else {
				responseString = JMIO.toString(entity.getContent());
			}
			EntityUtils.consume(entity);
		}
		return responseString;
	}
}
