package kr.jm.utils.helper;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.jm.utils.exception.JMExceptionManager;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class JMJson.
 */
@Slf4j
public class JMJson {

	private static ObjectMapper jsonMapper = new ObjectMapper()
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

	/**
	 * To json string.
	 *
	 * @param <D>
	 *            the generic type
	 * @param dataObject
	 *            the data object
	 * @return the string
	 */
	public static <D> String toJsonString(D dataObject) {
		try {
			return jsonMapper.writeValueAsString(dataObject);
		} catch (JsonProcessingException e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"toJsonString", dataObject);
		}
	}

	/**
	 * To json string or null.
	 *
	 * @param <D>
	 *            the generic type
	 * @param dataObject
	 *            the data object
	 * @return the string
	 */
	public static <D> String toJsonStringOrNull(D dataObject) {
		try {
			return jsonMapper.writeValueAsString(dataObject);
		} catch (JsonProcessingException e) {
			return null;
		}
	}

	/**
	 * To json string.
	 *
	 * @param jsonFile
	 *            the json file
	 * @return the string
	 */
	public static String toJsonString(File jsonFile) {
		return JMFile.readString(jsonFile);
	}

	/**
	 * To json file.
	 *
	 * @param jsonString
	 *            the json string
	 * @param returnJsonFile
	 *            the return json file
	 * @return the file
	 */
	public static File toJsonFile(String jsonString, File returnJsonFile) {
		try {
			jsonMapper.writeValue(returnJsonFile, jsonString);
			return returnJsonFile;
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"toJsonFile", jsonString);
		}
	}

	/**
	 * To json file or null.
	 *
	 * @param jsonString
	 *            the json string
	 * @param returnJsonFile
	 *            the return json file
	 * @return the file
	 */
	public static File toJsonFileOrNull(String jsonString,
			File returnJsonFile) {
		try {
			jsonMapper.writeValue(returnJsonFile, jsonString);
			return returnJsonFile;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * To json file.
	 *
	 * @param <D>
	 *            the generic type
	 * @param dataObject
	 *            the data object
	 * @param returnJsonFile
	 *            the return json file
	 * @return the file
	 */
	public static <D> File toJsonFile(D dataObject, File returnJsonFile) {
		try {
			jsonMapper.writeValue(returnJsonFile, dataObject);
			return returnJsonFile;
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"toJsonFile", dataObject);
		}
	}

	/**
	 * To json file or null.
	 *
	 * @param <D>
	 *            the generic type
	 * @param dataObject
	 *            the data object
	 * @param returnJsonFile
	 *            the return json file
	 * @return the file
	 */
	public static <D> File toJsonFileOrNull(D dataObject, File returnJsonFile) {
		try {
			jsonMapper.writeValue(returnJsonFile, dataObject);
			return returnJsonFile;
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"toJsonFile", dataObject);
		}
	}

	/**
	 * From bytes.
	 *
	 * @param <T>
	 *            the generic type
	 * @param bytes
	 *            the bytes
	 * @param typeReference
	 *            the type reference
	 * @return the t
	 */
	public static <T> T fromBytes(byte[] bytes,
			TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(bytes, typeReference);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"fromBytes", new String(bytes));
		}
	}

	/**
	 * From bytes or null.
	 *
	 * @param <T>
	 *            the generic type
	 * @param bytes
	 *            the bytes
	 * @param typeReference
	 *            the type reference
	 * @return the t
	 */
	public static <T> T fromBytesOrNull(byte[] bytes,
			TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(bytes, typeReference);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * From bytes.
	 *
	 * @param <T>
	 *            the generic type
	 * @param bytes
	 *            the bytes
	 * @param c
	 *            the c
	 * @return the t
	 */
	public static <T> T fromBytes(byte[] bytes, Class<T> c) {
		try {
			return jsonMapper.readValue(bytes, c);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"fromBytes", new String(bytes));
		}
	}

	/**
	 * From bytes or null.
	 *
	 * @param <T>
	 *            the generic type
	 * @param bytes
	 *            the bytes
	 * @param c
	 *            the c
	 * @return the t
	 */
	public static <T> T fromBytesOrNull(byte[] bytes, Class<T> c) {
		try {
			return jsonMapper.readValue(bytes, c);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * From json string.
	 *
	 * @param <T>
	 *            the generic type
	 * @param jsonString
	 *            the json string
	 * @param typeReference
	 *            the type reference
	 * @return the t
	 */
	public static <T> T fromJsonString(String jsonString,
			TypeReference<T> typeReference) {
		return fromBytes(jsonString.getBytes(), typeReference);
	}

	/**
	 * From json string or null.
	 *
	 * @param <T>
	 *            the generic type
	 * @param jsonString
	 *            the json string
	 * @param typeReference
	 *            the type reference
	 * @return the t
	 */
	public static <T> T fromJsonStringOrNull(String jsonString,
			TypeReference<T> typeReference) {
		return fromBytesOrNull(jsonString.getBytes(), typeReference);
	}

	/**
	 * From json string.
	 *
	 * @param <T>
	 *            the generic type
	 * @param jsonString
	 *            the json string
	 * @param c
	 *            the c
	 * @return the t
	 */
	public static <T> T fromJsonString(String jsonString, Class<T> c) {
		return fromBytes(jsonString.getBytes(), c);
	}

	/**
	 * From json string or null.
	 *
	 * @param <T>
	 *            the generic type
	 * @param jsonString
	 *            the json string
	 * @param c
	 *            the c
	 * @return the t
	 */
	public static <T> T fromJsonStringOrNull(String jsonString, Class<T> c) {
		return fromBytesOrNull(jsonString.getBytes(), c);
	}

	/**
	 * From json file.
	 *
	 * @param <T>
	 *            the generic type
	 * @param jsonFile
	 *            the json file
	 * @param typeReference
	 *            the type reference
	 * @return the t
	 */
	public static <T> T fromJsonFile(File jsonFile,
			TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(jsonFile, typeReference);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"fromJsonFile", jsonFile);
		}
	}

	/**
	 * From json file or null.
	 *
	 * @param <T>
	 *            the generic type
	 * @param jsonFile
	 *            the json file
	 * @param typeReference
	 *            the type reference
	 * @return the t
	 */
	public static <T> T fromJsonFileOrNull(File jsonFile,
			TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(jsonFile, typeReference);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * From json file.
	 *
	 * @param <T>
	 *            the generic type
	 * @param jsonFile
	 *            the json file
	 * @param c
	 *            the c
	 * @return the t
	 */
	public static <T> T fromJsonFile(File jsonFile, Class<T> c) {
		try {
			return jsonMapper.readValue(jsonFile, c);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"fromJsonFile", jsonFile);
		}
	}

	/**
	 * From json file or null.
	 *
	 * @param <T>
	 *            the generic type
	 * @param jsonFile
	 *            the json file
	 * @param c
	 *            the c
	 * @return the t
	 */
	public static <T> T fromJsonFileOrNull(File jsonFile, Class<T> c) {
		try {
			return jsonMapper.readValue(jsonFile, c);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * From json input stream.
	 *
	 * @param <T>
	 *            the generic type
	 * @param inputStream
	 *            the input stream
	 * @param typeReference
	 *            the type reference
	 * @return the t
	 */
	public static <T> T fromJsonInputStream(InputStream inputStream,
			TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(inputStream, typeReference);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"fromJsonInputStream", inputStream);
		}
	}

	/**
	 * From json input stream or null.
	 *
	 * @param <T>
	 *            the generic type
	 * @param inputStream
	 *            the input stream
	 * @param typeReference
	 *            the type reference
	 * @return the t
	 */
	public static <T> T fromJsonInputStreamOrNull(InputStream inputStream,
			TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(inputStream, typeReference);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * From json input stream.
	 *
	 * @param <T>
	 *            the generic type
	 * @param inputStream
	 *            the input stream
	 * @param c
	 *            the c
	 * @return the t
	 */
	public static <T> T fromJsonInputStream(InputStream inputStream,
			Class<T> c) {
		try {
			return jsonMapper.readValue(inputStream, c);
		} catch (Exception e) {
			return JMExceptionManager.handleExceptionAndReturnNull(log, e,
					"fromJsonInputStream", inputStream);
		}
	}

	/**
	 * From json input stream or null.
	 *
	 * @param <T>
	 *            the generic type
	 * @param inputStream
	 *            the input stream
	 * @param c
	 *            the c
	 * @return the t
	 */
	public static <T> T fromJsonInputStreamOrNull(InputStream inputStream,
			Class<T> c) {
		try {
			return jsonMapper.readValue(inputStream, c);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * From json resource.
	 *
	 * @param <T>
	 *            the generic type
	 * @param resourceInClasspath
	 *            the resource in classpath
	 * @param typeReference
	 *            the type reference
	 * @return the t
	 */
	public static <T> T fromJsonResource(String resourceInClasspath,
			TypeReference<T> typeReference) {
		return fromJsonInputStream(
				JMResources.getResourceInputStream(resourceInClasspath),
				typeReference);
	}

	/**
	 * From json resource.
	 *
	 * @param <T>
	 *            the generic type
	 * @param resourceInClasspath
	 *            the resource in classpath
	 * @param c
	 *            the c
	 * @return the t
	 */
	public static <T> T fromJsonResource(String resourceInClasspath,
			Class<T> c) {
		return fromJsonInputStream(
				JMResources.getResourceInputStream(resourceInClasspath), c);
	}

	/**
	 * From rest or classpath or file path.
	 *
	 * @param <T>
	 *            the generic type
	 * @param resourceInRestUrlOrClasspathOrFilePath
	 *            the resource in rest url or classpath or file path
	 * @param typeReference
	 *            the type reference
	 * @return the t
	 */
	public static <T> T fromRestOrClasspathOrFilePath(
			String resourceInRestUrlOrClasspathOrFilePath,
			TypeReference<T> typeReference) {
		return fromJsonString(
				JMRestfulResource.getStringfromRestOrClasspathOrFilePath(
						resourceInRestUrlOrClasspathOrFilePath),
				typeReference);
	}

	/**
	 * From classpath or file path.
	 *
	 * @param <T>
	 *            the generic type
	 * @param resourceInClasspathOrFilePath
	 *            the resource in classpath or file path
	 * @param typeReference
	 *            the type reference
	 * @return the t
	 */
	public static <T> T fromClasspathOrFilePath(
			String resourceInClasspathOrFilePath,
			TypeReference<T> typeReference) {
		return fromJsonString(JMResources.getStringFromClasspathOrFilePath(
				resourceInClasspathOrFilePath), typeReference);
	}

	/**
	 * Convert map.
	 *
	 * @param <T>
	 *            the generic type
	 * @param pojoBean
	 *            the pojo bean
	 * @return the hash map
	 */
	public static <T> HashMap<String, Object> convertMap(T pojoBean) {
		return jsonMapper.convertValue(pojoBean,
				new TypeReference<HashMap<String, Object>>() {
				});
	}

}
