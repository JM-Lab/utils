package kr.jm.utils.helper;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JMCollections {
	public static boolean isNullOrEmpty(Collection<?> collection) {
		return (collection == null || collection.size() == 0) ? true : false;
	}

	public static <V> V getLast(List<V> list) {
		return isNullOrEmpty(list) ? null : list.get(list.size() - 1);
	}

	public static <V extends Comparable<V>> List<V> sort(List<V> list) {
		Collections.sort(list);
		return list;
	}

	public static <V> List<V> sort(List<V> list,
			Comparator<? super V> comparator) {
		Collections.sort(list, comparator);
		return list;
	}

	public static <V> V[] sort(V[] array, Comparator<? super V> comparator) {
		Arrays.sort(array, comparator);
		return array;
	}

	public static <K, V> Map<K, V> sort(Map<K, V> map,
			Comparator<? super K> comparator) {
		TreeMap<K, V> sortedMap = new TreeMap<K, V>(comparator);
		sortedMap.putAll(map);
		return sortedMap;
	}

	public static <K, V> Map<K, V> sort(Map<K, V> map) {
		TreeMap<K, V> sortedMap = new TreeMap<K, V>();
		sortedMap.putAll(map);
		return sortedMap;
	}

	public static <K, V> V getValueOrNew(Map<K, V> map, K key, V newValue) {
		synchronized (map) {
			V value = map.get(key);
			if (value == null) {
				value = newValue;
				map.put(key, value);
			}
			return value;
		}
	}

	public static <K, V> V getValueOrNew(Map<K, V> map, K key,
			NewValueBuilder<V> newValueBuilder) {
		synchronized (map) {
			V value = map.get(key);
			if (value == null) {
				value = newValueBuilder.buildNewValue();
				map.put(key, value);
			}
			return value;
		}
	}

	public interface NewValueBuilder<V> {
		public V buildNewValue();
	}

	public static <E> List<E> buildList(
			@SuppressWarnings("unchecked") E... objects) {
		return Arrays.asList(objects);
	}

}