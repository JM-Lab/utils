package kr.jm.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CollectionHelper {
	public static boolean isNullOrEmpty(Collection<?> collection) {
		return (collection == null || collection.size() == 0) ? true : false;
	}

	public static <V> boolean isNullOrEmpty(V[] array) {
		return (array == null || array.length == 0) ? true : false;
	}

	public static <V> V getLast(List<V> list) {
		return isNullOrEmpty(list) ? null : list.get(list.size() - 1);
	}

	public static <V> V getLast(V[] array) {
		return isNullOrEmpty(array) ? null : array[array.length - 1];
	}

	public static <V extends Comparable<V>> List<V> sort(List<V> list) {
		Collections.sort(list);
		return list;
	}

	public static <V extends Comparable<V>> V[] sort(V[] array) {
		Arrays.sort(array);
		return array;
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
}
