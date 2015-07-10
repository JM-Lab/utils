package kr.jm.utils.helper;

import java.io.File;
import java.io.IOException;
import java.util.List;

import kr.jm.utils.exception.JMExceptionManager;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.FileUtils;

@Slf4j
public class JMFileIO {

	public static boolean writeString(String inputString, File targetfile) {
		if (!targetfile.exists()) {
			try {
				FileUtils.writeStringToFile(targetfile, inputString);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public static String readString(File targetfile) {
		try {
			return FileUtils.readFileToString(targetfile);
		} catch (IOException e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"readString", targetfile);
		}
	}

	public static String readString(File targetfile, String encoding) {
		try {
			return FileUtils.readFileToString(targetfile, encoding);
		} catch (IOException e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"readString", targetfile);
		}
	}

	public static String readString(String classpathOrFilePath) {
		return readString(getFile(classpathOrFilePath));
	}

	public static String readString(String classpathOrFilePath, String encoding) {
		return readString(getFile(classpathOrFilePath), encoding);
	}

	public static List<String> readLines(File targetfile) {
		try {
			return FileUtils.readLines(targetfile);
		} catch (IOException e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"readLines", targetfile);
		}
	}

	public static List<String> readLines(File targetfile, String encoding) {
		try {
			return FileUtils.readLines(targetfile, encoding);
		} catch (IOException e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"readLines", targetfile);
		}
	}

	public static List<String> readLines(String classpathOrFilePath) {
		return readLines(getFile(classpathOrFilePath));
	}

	public static List<String> readLines(String classpathOrFilePath,
			String encoding) {
		return readLines(getFile(classpathOrFilePath), encoding);
	}

	private static File getFile(String classpathOrFilePath) {
		try {
			return new File(JMResources.getResourceURI(classpathOrFilePath));
		} catch (Exception e) {
			return new File(classpathOrFilePath);
		}
	}

}
