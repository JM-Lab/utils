package kr.jm.utils.helper;

import java.io.File;
import java.io.InputStream;

import kr.jm.utils.HttpGetRequester;
import kr.jm.utils.exception.JMExceptionManager;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
public class JMJson {

	private static ObjectMapper jsonMapper = new ObjectMapper()
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

	public static <D> String toJsonString(D dataObject) {
		try {
			return jsonMapper.writeValueAsString(dataObject);
		} catch (JsonProcessingException e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"toJsonString", dataObject);
		}
	}

	public static String toJsonString(File jsonFile) {
		return JMFileIO.readString(jsonFile);
	}

	@Deprecated
	public static String toJsonString(String resourceInClasspath) {
		return toJsonString(JMResources.getResourceFile(resourceInClasspath));
	}

	public static File toJsonFile(String jsonString, File returnJsonFile) {
		try {
			jsonMapper.writeValue(returnJsonFile, jsonString);
			return returnJsonFile;
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"toJsonFile", jsonString);
		}
	}

	public static <D> File toJsonFile(D dataObject, File returnJsonFile) {
		try {
			jsonMapper.writeValue(returnJsonFile, dataObject);
			return returnJsonFile;
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"toJsonFile", dataObject);
		}
	}

	public static <T> T fromBytes(byte[] bytes, TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(bytes, typeReference);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"fromBytes", new String(bytes));
		}
	}

	public static <T> T fromBytes(byte[] bytes, Class<T> c) {
		try {
			return jsonMapper.readValue(bytes, c);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"fromBytes", new String(bytes));
		}
	}

	public static <T> T fromJsonString(String jsonString,
			TypeReference<T> typeReference) {
		return fromBytes(jsonString.getBytes(), typeReference);
	}

	public static <T> T fromJsonString(String jsonString, Class<T> c) {
		return fromBytes(jsonString.getBytes(), c);
	}

	public static <T> T fromJsonFile(File jsonFile,
			TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(jsonFile, typeReference);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"fromJsonFile", jsonFile);
		}
	}

	public static <T> T fromJsonFile(File jsonFile, Class<T> c) {
		try {
			return jsonMapper.readValue(jsonFile, c);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"fromJsonFile", jsonFile);
		}
	}

	public static <T> T fromJsonInputStream(InputStream inputStream,
			TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(inputStream, typeReference);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"fromJsonInputStream", inputStream);
		}
	}

	public static <T> T fromJsonInputStream(InputStream inputStream, Class<T> c) {
		try {
			return jsonMapper.readValue(inputStream, c);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"fromJsonInputStream", inputStream);
		}
	}

	public static <T> T fromJsonResource(String resourceInClasspath,
			TypeReference<T> typeReference) {
		return fromJsonInputStream(
				JMResources.getResourceInputStream(resourceInClasspath),
				typeReference);
	}

	public static <T> T fromJsonResource(String resourceInClasspath, Class<T> c) {
		return fromJsonInputStream(
				JMResources.getResourceInputStream(resourceInClasspath), c);
	}

	public static <T> T fromRestOrClasspathOrFilePath(
			String resourceInRestUrlOrClasspathOrFilePath,
			TypeReference<T> typeReference) {
		return fromJsonString(
				JMFileIO.readString(resourceInRestUrlOrClasspathOrFilePath),
				typeReference);
	}

	public static <T> T fromClasspathOrFilePath(
			String resourceInClasspathOrFilePath, TypeReference<T> typeReference) {
		return fromJsonString(
				JMFileIO.readString(resourceInClasspathOrFilePath),
				typeReference);
	}

	public static String fromRestOrClasspathOrFilePath(
			String resourceInRestUrlOrClasspathOrFilePath) {
		return resourceInRestUrlOrClasspathOrFilePath.startsWith("http") ? HttpGetRequester
				.getResponseAsString(resourceInRestUrlOrClasspathOrFilePath)
				: JMFileIO.readString(resourceInRestUrlOrClasspathOrFilePath);
	}

}
