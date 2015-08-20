package kr.jm.utils.helper;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Consumer;

public class JMCollections {

	public static <T, C extends Collection<T>> Optional<C> getOptional(
			C collection) {
		return Optional.ofNullable(collection).filter(c -> c.size() > 0);
	}

	public static <K, V, M extends Map<K, V>> Optional<M> getOptional(M map) {
		return Optional.ofNullable(map).filter(m -> m.size() > 0);
	}

	public static <T, C extends Collection<T>> void ifNotNullOrEmptyConsume(
			C collection, Consumer<C> consumer) {
		getOptional(collection).ifPresent(consumer);
	}

	public static boolean isNotNullOrEmpty(Collection<?> collection) {
		return !isNullOrEmpty(collection);
	}

	public static boolean isNullOrEmpty(Collection<?> collection) {
		return collection == null || collection.size() == 0 ? true : false;
	}

	public static boolean isNotNullOrEmpty(Map<?, ?> map) {
		return !isNullOrEmpty(map);
	}

	public static boolean isNullOrEmpty(Map<?, ?> map) {
		return map == null || map.size() == 0 ? true : false;
	}

	public static <T, L extends List<T>> T getLast(List<T> list) {
		return isNullOrEmpty(list) ? null : list.get(list.size() - 1);
	}

	public static <T extends Comparable<T>> List<T> sort(List<T> list) {
		Collections.sort(list);
		return list;
	}

	public static <T> List<T> sort(List<T> list,
			Comparator<? super T> comparator) {
		Collections.sort(list, comparator);
		return list;
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
			if (!map.containsKey(key))
				map.put(key, newValue);
		}
		return map.get(key);
	}

	public static <K, V, M extends Map<K, V>> V getValueOrNew(M map, K key,
			NewValueBuilder<V> newValueBuilder) {
		synchronized (map) {
			if (!map.containsKey(key))
				map.put(key, newValueBuilder.buildNewValue());
		}
		return map.get(key);
	}

	public interface NewValueBuilder<V> {
		public V buildNewValue();
	}

	@SuppressWarnings("unchecked")
	public static <E> List<E> buildList(E... objects) {
		return Arrays.asList(objects);
	}

	public static List<String> buildListFromCsv(String csvString) {
		return buildList(JMArrays.buildArrayFromCsv(csvString));
	}

	public static List<String> buildListWithDelimeter(
			String stringWithDelimeter, String delimeter) {
		return buildList(JMArrays.buildArrayWithDelimeter(stringWithDelimeter,
				delimeter));
	}

}
