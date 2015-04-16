package kr.jm.utils;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//use JMJson
@Deprecated
public class CollectionPrinter {

	static public String CollectionToJSONString(List<?> list) {
		if (list == null || list.size() == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		for (Object o : list) {
			buildAppendString(sb, o).append(',').append(' ');
		}
		return sb.delete(sb.length() - 2, sb.length()).append(']').toString();
	}

	private static StringBuilder buildAppendString(StringBuilder sb, Object o) {

		if (o instanceof String) {
			sb.append('\"').append(o.toString()).append('\"');
		} else if (o instanceof List) {
			sb.append(CollectionToJSONString((List<?>) o));
		} else if (o instanceof Map) {
			sb.append(CollectionToJSONString((Map<?, ?>) o));
		} else if (o == null) {
			sb.append("null");
		} else {
			sb.append(o.toString());
		}
		return sb;
	}

	public static String CollectionToJSONString(Map<?, ?> map) {
		if (map == null || map.size() == 0) {
			return "{}";
		}
		StringBuilder sb = new StringBuilder("{");
		for (Object o : map.entrySet()) {
			Entry<?, ?> e = (Entry<?, ?>) o;
			buildAppendString(sb, e.getKey()).append('=');
			buildAppendString(sb, e.getValue()).append(',').append(' ');
		}
		return sb.delete(sb.length() - 2, sb.length()).append('}').toString();
	}
}
