package kr.jm.utils;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * The Class HttpGetRequester.
 */
public class HttpGetRequester {

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
		return getRestApiResponseAsObject(uri, typeReference);
	}

	/**
	 * Gets the response as string.
	 *
	 * @param uri
	 *            the uri
	 * @return the response as string
	 */
	public static String getResponseAsString(String uri) {
		return HttpRequester.getResponseAsString(uri);
	}

}
