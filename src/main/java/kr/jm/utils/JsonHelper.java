package kr.jm.utils;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
public class JsonHelper {

	private static ObjectMapper jsonMapper = new ObjectMapper();

	public static <D> String toJsonString(D dataObject) {
		try {
			return jsonMapper.writeValueAsString(dataObject);
		} catch (JsonProcessingException e) {
			return handleExetion(e, "toJsonString", dataObject);
		}
	}

	public static String toJsonString(File jsonFile) {
		return FileIO.readString(jsonFile);
	}

	public static File toJsonFile(String jsonString, File returnJsonFile) {
		try {
			jsonMapper.writeValue(returnJsonFile, jsonString);
			return returnJsonFile;
		} catch (Exception e) {
			return handleExetion(e, "toJsonFile", jsonString);
		}
	}

	public static <D> File toJsonFile(D dataObject, File returnJsonFile) {
		try {
			jsonMapper.writeValue(returnJsonFile, dataObject);
			return returnJsonFile;
		} catch (Exception e) {
			return handleExetion(e, "toJsonFile", dataObject);
		}
	}

	public static <T> T fromJsonString(String jsonString,
			TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(jsonString.getBytes(), typeReference);
		} catch (Exception e) {
			return handleExetion(e, "fromJsonString", jsonString);
		}
	}

	public static <T> T fromJsonString(String jsonString, Class<T> c) {
		try {
			return jsonMapper.readValue(jsonString.getBytes(), c);
		} catch (Exception e) {
			return handleExetion(e, "fromJsonString", jsonString);
		}
	}

	public static <T> T fromJsonFile(File jsonFile,
			TypeReference<T> typeReference) {
		try {
			return jsonMapper.readValue(jsonFile, typeReference);
		} catch (Exception e) {
			return handleExetion(e, "fromJsonString", jsonFile);
		}
	}

	public static <T> T fromJsonFile(final File jsonFile, final Class<T> c) {
		try {
			return jsonMapper.readValue(jsonFile, c);
		} catch (Exception e) {
			return handleExetion(e, "fromJsonFile", jsonFile);
		}
	}

	private static <T> T handleExetion(Exception e, String method, Object source) {
		LogHelper.logExeption(log, e, method, source);
		return null;
	}

}
