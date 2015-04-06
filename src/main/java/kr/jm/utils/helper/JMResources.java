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
import java.util.Properties;

public class JMResources {

	public static URL getResourceURL(String pathInClassPath) {
		return ClassLoader.getSystemResource(pathInClassPath);
	}

	public static URI getResourceURI(String pathInClassPath) {
		try {
			return getResourceURL(pathInClassPath).toURI();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	// can't instantiate java.io.File object from file in jar
	public static File getResourceFile(String pathInClassPath) {
		return new File(getResourceURI(pathInClassPath));
	}

	public static Properties getProperties(String pathInClassPath) {
		Properties properties = new Properties();
		try {
			InputStream is = ClassLoader
					.getSystemResourceAsStream(pathInClassPath);
			properties.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
			return properties;
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
			e.printStackTrace();
			return properties;
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
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}

	}

}
