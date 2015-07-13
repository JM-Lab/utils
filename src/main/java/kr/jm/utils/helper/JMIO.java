package kr.jm.utils.helper;

import java.io.InputStream;
import java.util.List;

import kr.jm.utils.HttpGetRequester;

public class JMIO {

	private static final String HTTP = "http";

	public static String getStringfromRestOrClasspathOrFilePath(
			String resourceInRestUrlOrClasspathOrFilePath, String encoding) {
		return resourceInRestUrlOrClasspathOrFilePath.startsWith(HTTP) ? HttpGetRequester
				.getResponseAsString(resourceInRestUrlOrClasspathOrFilePath)
				: getStringFromClasspathOrFilePath(resourceInRestUrlOrClasspathOrFilePath);
	}

	public static String getStringfromRestOrClasspathOrFilePath(
			String resourceInRestUrlOrClasspathOrFilePath) {
		return resourceInRestUrlOrClasspathOrFilePath.startsWith(HTTP) ? HttpGetRequester
				.getResponseAsString(resourceInRestUrlOrClasspathOrFilePath)
				: getStringFromClasspathOrFilePath(resourceInRestUrlOrClasspathOrFilePath);
	}

	public static String getStringFromClasspathOrFilePath(
			String resourceInClasspathOrFilePath) {
		InputStream resourceInputStream = JMResources
				.getResourceInputStream(resourceInClasspathOrFilePath);
		return resourceInputStream != null ? JMResources
				.readString(resourceInputStream) : JMFileIO
				.readString(resourceInClasspathOrFilePath);
	}

	public static String getStringFromClasspathOrFilePath(
			String resourceInClasspathOrFilePath, String encoding) {
		InputStream resourceInputStream = JMResources
				.getResourceInputStream(resourceInClasspathOrFilePath);
		return resourceInputStream != null ? JMResources.readString(
				resourceInputStream, encoding) : JMFileIO.readString(
				resourceInClasspathOrFilePath, encoding);
	}

	public static List<String> readLinesfromRestOrClasspathOrFilePath(
			String resourceInRestUrlOrClasspathOrFilePath) {
		return JMString
				.splitLineByLine(getStringfromRestOrClasspathOrFilePath(resourceInRestUrlOrClasspathOrFilePath));
	}

	public static List<String> readLinesfromClasspathOrFilePath(
			String resourceInClasspathOrFilePath) {
		InputStream resourceInputStream = JMResources
				.getResourceInputStream(resourceInClasspathOrFilePath);
		return resourceInputStream != null ? JMResources
				.readLines(resourceInputStream) : JMFileIO
				.readLines(resourceInClasspathOrFilePath);
	}

}
