package kr.jm.utils.helper;

import java.util.List;

import kr.jm.utils.HttpGetRequester;
import kr.jm.utils.datastructure.JMCollections;

/**
 * The Class JMRestfulResource.
 */
public class JMRestfulResource {
	private static final String HTTP = "http";

	/**
	 * Gets the stringfrom rest or classpath or file path.
	 *
	 * @param resourceInRestUrlOrClasspathOrFilePath
	 *            the resource in rest url or classpath or file path
	 * @param encoding
	 *            the encoding
	 * @return the stringfrom rest or classpath or file path
	 */
	public static String getStringfromRestOrClasspathOrFilePath(
			String resourceInRestUrlOrClasspathOrFilePath, String encoding) {
		return resourceInRestUrlOrClasspathOrFilePath.startsWith(HTTP)
				? HttpGetRequester.getResponseAsString(
						resourceInRestUrlOrClasspathOrFilePath)
				: JMResources.getStringFromClasspathOrFilePath(
						resourceInRestUrlOrClasspathOrFilePath);
	}

	/**
	 * Gets the stringfrom rest or classpath or file path.
	 *
	 * @param resourceInRestUrlOrClasspathOrFilePath
	 *            the resource in rest url or classpath or file path
	 * @return the stringfrom rest or classpath or file path
	 */
	public static String getStringfromRestOrClasspathOrFilePath(
			String resourceInRestUrlOrClasspathOrFilePath) {
		return resourceInRestUrlOrClasspathOrFilePath.startsWith(HTTP)
				? HttpGetRequester.getResponseAsString(
						resourceInRestUrlOrClasspathOrFilePath)
				: JMResources.getStringFromClasspathOrFilePath(
						resourceInRestUrlOrClasspathOrFilePath);
	}

	/**
	 * Read linesfrom rest or classpath or file path.
	 *
	 * @param resourceInRestUrlOrClasspathOrFilePath
	 *            the resource in rest url or classpath or file path
	 * @return the list
	 */
	public static List<String> readLinesfromRestOrClasspathOrFilePath(
			String resourceInRestUrlOrClasspathOrFilePath) {
		return JMCollections
				.buildListByLine(getStringfromRestOrClasspathOrFilePath(
						resourceInRestUrlOrClasspathOrFilePath));
	}

}
