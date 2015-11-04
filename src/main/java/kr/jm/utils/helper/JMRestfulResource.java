package kr.jm.utils.helper;

import java.util.List;

import kr.jm.utils.HttpGetRequester;
import kr.jm.utils.datastructure.JMCollections;

public class JMRestfulResource {
	private static final String HTTP = "http";

	public static String getStringfromRestOrClasspathOrFilePath(
			String resourceInRestUrlOrClasspathOrFilePath, String encoding) {
		return resourceInRestUrlOrClasspathOrFilePath.startsWith(HTTP) ? HttpGetRequester
				.getResponseAsString(resourceInRestUrlOrClasspathOrFilePath)
				: JMResources
						.getStringFromClasspathOrFilePath(resourceInRestUrlOrClasspathOrFilePath);
	}

	public static String getStringfromRestOrClasspathOrFilePath(
			String resourceInRestUrlOrClasspathOrFilePath) {
		return resourceInRestUrlOrClasspathOrFilePath.startsWith(HTTP) ? HttpGetRequester
				.getResponseAsString(resourceInRestUrlOrClasspathOrFilePath)
				: JMResources
						.getStringFromClasspathOrFilePath(resourceInRestUrlOrClasspathOrFilePath);
	}

	public static List<String> readLinesfromRestOrClasspathOrFilePath(
			String resourceInRestUrlOrClasspathOrFilePath) {
		return JMCollections
				.buildListByLine(getStringfromRestOrClasspathOrFilePath(resourceInRestUrlOrClasspathOrFilePath));
	}

}
