package kr.jm.utils;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.type.TypeReference;

import kr.jm.utils.exception.JMExceptionManager;
import kr.jm.utils.helper.JMJson;
import kr.jm.utils.helper.JMString;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class HttpRequester.
 */
@Slf4j
public class HttpRequester {
	private static final Charset UTF_8 = Charset.forName("UTF-8");
	private static CloseableHttpClient HttpClient;

	/**
	 * Gets the rest api response as object.
	 *
	 * @param <T>
	 *            the generic type
	 * @param uri
	 *            the uri
	 * @param typeReference
	 *            the type reference
	 * @return the rest api response as object
	 */
	public static <T> T getRestApiResponseAsObject(String uri,
			TypeReference<T> typeReference) {
		try {
			return JMJson.fromJsonString(getResponseAsString(uri),
					typeReference);
		} catch (Exception e) {
			throw JMExceptionManager.handleExceptionAndReturnRuntimeEx(log, e,
					"getRestApiResponseAsObject", uri, typeReference);
		}
	}

	/**
	 * Gets the response as string.
	 *
	 * @param uri
	 *            the uri
	 * @return the response as string
	 */
	public static String getResponseAsString(String uri) {
		return request(new HttpGet(uri));
	}

	/**
	 * Gets the response as string.
	 *
	 * @param uri
	 *            the uri
	 * @param header
	 *            the header
	 * @return the response as string
	 */
	public static String getResponseAsString(URI uri, Header header) {
		return getResponseAsString(uri.toString(), header);
	}

	/**
	 * Gets the response as string.
	 *
	 * @param uri
	 *            the uri
	 * @param header
	 *            the header
	 * @return the response as string
	 */
	public static String getResponseAsString(String uri, Header header) {
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setHeader(header);
		request(httpGet);
		return request(httpGet);
	}

	/**
	 * Builds the uri.
	 *
	 * @param httpOrhttps
	 *            the http orhttps
	 * @param host
	 *            the host
	 * @param path
	 *            the path
	 * @param paramMap
	 *            the param map
	 * @return the uri
	 */
	public static URI buildUri(String httpOrhttps, String host, String path,
			Map<String, String> paramMap) {
		try {
			return new URIBuilder().setScheme(httpOrhttps).setHost(host)
					.setPath(path)
					.setParameters(buildNameValuePareList(paramMap)).build();
		} catch (URISyntaxException e) {
			throw JMExceptionManager.handleExceptionAndReturnRuntimeEx(log, e,
					"getResponseAsString", httpOrhttps, host, path, paramMap);
		}
	}

	/**
	 * Builds the name value pare list.
	 *
	 * @param keyValueMap
	 *            the key value map
	 * @return the list
	 */
	public static List<NameValuePair>
			buildNameValuePareList(Map<String, String> keyValueMap) {
		return keyValueMap.entrySet().stream()
				.map(entry -> new BasicNameValuePair(entry.getKey(),
						entry.getValue()))
				.collect(toList());
	}

	/**
	 * Post response as string.
	 *
	 * @param uri
	 *            the uri
	 * @param header
	 *            the header
	 * @param httpEntity
	 *            the http entity
	 * @return the string
	 */
	public static String postResponseAsString(URI uri, Header header,
			HttpEntity httpEntity) {
		return postResponseAsString(uri.toString(), header, httpEntity);
	}

	/**
	 * Post response as string.
	 *
	 * @param uri
	 *            the uri
	 * @param header
	 *            the header
	 * @param httpEntity
	 *            the http entity
	 * @return the string
	 */
	public static String postResponseAsString(String uri, Header header,
			HttpEntity httpEntity) {
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setHeader(header);
		httpPost.setEntity(httpEntity);
		return request(httpPost);
	}

	/**
	 * Builds the http entity.
	 *
	 * @param object
	 *            the object
	 * @return the string entity
	 */
	public static StringEntity buildHttpEntity(Object object) {
		return buildHttpEntity(JMJson.toJsonString(object));
	}

	/**
	 * Builds the http entity.
	 *
	 * @param string
	 *            the string
	 * @return the string entity
	 */
	public static StringEntity buildHttpEntity(String string) {
		return buildHttpEntity(string, UTF_8);
	}

	/**
	 * Builds the http entity.
	 *
	 * @param string
	 *            the string
	 * @param charset
	 *            the charset
	 * @return the string entity
	 */
	public static StringEntity buildHttpEntity(String string, Charset charset) {
		return new StringEntity(string, charset);
	}

	/**
	 * Request.
	 *
	 * @param httpUriRequest
	 *            the http uri request
	 * @return the string
	 */
	public static String request(HttpUriRequest httpUriRequest) {
		try (CloseableHttpResponse response =
				getHttpClient().execute(httpUriRequest)) {
			HttpEntity httpEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode >= 200 && statusCode < 300)
				return EntityUtils.toString(httpEntity);
			throw new IllegalStateException(
					response.getStatusLine().getStatusCode() + JMString.SPACE
							+ response.getStatusLine().getReasonPhrase());
		} catch (IOException e) {
			throw JMExceptionManager.handleExceptionAndReturnRuntimeEx(log, e,
					"request", httpUriRequest);
		}
	}

	/**
	 * Gets the http client.
	 *
	 * @return the http client
	 */
	public static CloseableHttpClient getHttpClient() {
		return HttpClient == null ? HttpClient = HttpClients.createDefault()
				: HttpClient;
	}

	/**
	 * Sets the http client.
	 *
	 * @param httpClient
	 *            the http client
	 * @return the closeable http client
	 */
	public static CloseableHttpClient
			setHttpClient(CloseableHttpClient httpClient) {
		return HttpClient = httpClient;
	}
}
