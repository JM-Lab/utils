package kr.jm.utils.helper;

import java.io.File;
import java.io.InputStream;

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

	public static <D> String toJsonStringOrNull(D dataObject) {
		try {
			return jsonMapper.writeValueAsString(dataObject);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	public static String toJsonString(File jsonFile) {
		return JMFile.readString(jsonFile);
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

	public static File toJsonFileOrNull(String jsonString, File returnJsonFile) {
		try {
			jsonMapper.writeValue(returnJsonFile, jsonString);
			return returnJsonFile;
		} catch (Exception e) {
			return null;
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

	public static <D> File toJsonFileOrNull(D dataObject, File returnJsonFile) {
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

	public static <T> T fromBytesOrNull(byte[] bytes,
			TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(bytes, typeReference);
		} catch (Exception e) {
			return null;
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

	public static <T> T fromBytesOrNull(byte[] bytes, Class<T> c) {
		try {
			return jsonMapper.readValue(bytes, c);
		} catch (Exception e) {
			return null;
		}
	}

	public static <T> T fromJsonString(String jsonString,
			TypeReference<T> typeReference) {
		return fromBytes(jsonString.getBytes(), typeReference);
	}

	public static <T> T fromJsonStringOrNull(String jsonString,
			TypeReference<T> typeReference) {
		return fromBytesOrNull(jsonString.getBytes(), typeReference);
	}

	public static <T> T fromJsonString(String jsonString, Class<T> c) {
		return fromBytes(jsonString.getBytes(), c);
	}

	public static <T> T fromJsonStringOrNull(String jsonString, Class<T> c) {
		return fromBytesOrNull(jsonString.getBytes(), c);
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

	public static <T> T fromJsonFileOrNull(File jsonFile,
			TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(jsonFile, typeReference);
		} catch (Exception e) {
			return null;
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

	public static <T> T fromJsonFileOrNull(File jsonFile, Class<T> c) {
		try {
			return jsonMapper.readValue(jsonFile, c);
		} catch (Exception e) {
			return null;
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

	public static <T> T fromJsonInputStreamOrNull(InputStream inputStream,
			TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(inputStream, typeReference);
		} catch (Exception e) {
			return null;
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

	public static <T> T fromJsonInputStreamOrNull(InputStream inputStream,
			Class<T> c) {
		try {
			return jsonMapper.readValue(inputStream, c);
		} catch (Exception e) {
			return null;
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
				JMRestfulResource
						.getStringfromRestOrClasspathOrFilePath(resourceInRestUrlOrClasspathOrFilePath),
				typeReference);
	}

	public static <T> T fromClasspathOrFilePath(
			String resourceInClasspathOrFilePath, TypeReference<T> typeReference) {
		return fromJsonString(
				JMResources
						.getStringFromClasspathOrFilePath(resourceInClasspathOrFilePath),
				typeReference);
	}

}
