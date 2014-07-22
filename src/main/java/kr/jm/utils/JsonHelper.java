package kr.jm.utils;

import java.io.File;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonHelper {

	private static Gson gson = new GsonBuilder().disableHtmlEscaping()
			.serializeNulls().create();

	public static String toJsonString(Object object) {
		return gson.toJson(object);
	}

	public static String toJsonString(Object object, Type type) {
		return gson.toJson(object, type);
	}

	public static <T> String toJsonString(Object object, TypeToken<T> typeToken) {
		return gson.toJson(object, typeToken.getType());
	}

	public static String toJsonString(File jsonFile) {
		return FileIO.readString(jsonFile);
	}

	public static boolean toJsonFile(String jsonString, File returnJsonFile) {
		return FileIO.writeString(jsonString, returnJsonFile);
	}

	public static <T> boolean toJsonFile(T object, File returnJsonFile) {
		return toJsonFile(toJsonString(object, new TypeToken<T>() {
		}), returnJsonFile);
	}

	public static <T> T fromJsonString(String jsonString, TypeToken<T> typeToken) {
		return gson.fromJson(jsonString, typeToken.getType());
	}

	public static <T> T fromJsonString(String jsonString, Class<T> c) {
		return gson.fromJson(jsonString, c);
	}

	// JsonHelper.fromJsonFile(jsonFile, new TypeToken<Map<String, Map<String,
	// ComputeVO>>>() {});
	public static <T> T fromJsonFile(File jsonFile, TypeToken<T> typeToken) {
		return gson.fromJson(FileIO.readString(jsonFile), typeToken.getType());
	}

	public static <T> T fromJsonFile(File jsonFile, Class<T> c) {
		return gson.fromJson(FileIO.readString(jsonFile), c);
	}

}
