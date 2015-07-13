package kr.jm.utils.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import kr.jm.utils.exception.JMExceptionManager;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.IOUtils;

@Slf4j
public class JMResources {

	public static void setSystemPropertyIfIsNull(String key, Object value) {
		if (!System.getProperties().containsKey(key))
			System.setProperty(key, value.toString());
	}

	public static String getSystemProperty(String key) {
		return System.getProperty(key);
	}

	public static URL getResourceURL(String pathInClassPath) {
		return ClassLoader.getSystemResource(pathInClassPath);
	}

	public static URI getResourceURI(String pathInClassPath) {
		try {
			return getResourceURL(pathInClassPath).toURI();
		} catch (URISyntaxException e) {
			JMExceptionManager.logException(log, e, "getResourceURI",
					pathInClassPath);
			return null;
		}
	}

	// can't instantiate java.io.File object from file in jar
	@Deprecated
	public static File getResourceFile(String pathInClassPath) {
		return new File(getResourceURI(pathInClassPath));
	}

	public static InputStream getResourceInputStream(String pathInClassPath) {
		return ClassLoader.getSystemResourceAsStream(pathInClassPath);
	}

	public static Properties getProperties(String pathInClassPath) {
		Properties properties = new Properties();
		InputStream is = getResourceInputStream(pathInClassPath);
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"getProperties", pathInClassPath);
		}
		return properties;
	}

	public static Properties getProperties(File propertiesFile) {
		Properties properties = new Properties();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					propertiesFile));
			properties.load(reader);
			reader.close();
		} catch (IOException e) {
			JMExceptionManager.logException(log, e, "getProperties",
					propertiesFile);
		}
		return properties;
	}

	public static boolean saveProperties(Properties inProperties,
			File saveFile, String comment) {
		try {
			if (!saveFile.exists()) {
				saveFile.getParentFile().mkdirs();
				saveFile.createNewFile();
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile));
			inProperties.store(writer, comment);
			writer.close();
			return true;
		} catch (IOException e) {
			JMExceptionManager.logException(log, e, "saveProperties",
					inProperties, saveFile, comment);
			return false;
		}

	}

	public static String readString(InputStream resourceInputStream) {
		try {
			return IOUtils.toString(resourceInputStream);
		} catch (IOException e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"readString", resourceInputStream);
		}
	}

	public static String readString(InputStream resourceInputStream,
			String encoding) {
		try {
			return IOUtils.toString(resourceInputStream, encoding);
		} catch (IOException e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"readString", resourceInputStream, encoding);
		}
	}

	public static String readString(String resourceClasspath) {
		return readString(getResourceInputStream(resourceClasspath));
	}

	public static String readString(String resourceClasspath, String encoding) {
		return readString(getResourceInputStream(resourceClasspath), encoding);
	}

	public static List<String> readLines(InputStream resourceInputStream) {
		try {
			return IOUtils.readLines(resourceInputStream);
		} catch (IOException e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"readLines", resourceInputStream);
		}
	}

	public static List<String> readLines(InputStream resourceInputStream,
			String encoding) {
		try {
			return IOUtils.readLines(resourceInputStream, encoding);
		} catch (IOException e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"readLines", resourceInputStream, encoding);
		}
	}

	public static List<String> readLines(String resourceClasspath) {
		return readLines(getResourceInputStream(resourceClasspath));
	}

	public static List<String> readLines(String resourceClasspath,
			String encoding) {
		return readLines(getResourceInputStream(resourceClasspath), encoding);
	}

}
