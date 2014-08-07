package kr.jm.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListHelper {
	public static boolean isListNullOrEmpty(List<?> list) {
		return (list == null || list.size() == 0) ? true : false;
	}

	public static <R> R getLast(List<R> list) {
		return isListNullOrEmpty(list) ? null : list.get(list.size() - 1);
	}
	
	public static <T extends Comparable<T>> List<T> sort(List<T> list){
		Collections.sort(list);
		return list;
	}
	
	public static <T> List<T> sort(List<T> list, Comparator<? super T> comparator){
		Collections.sort(list, comparator);
		return list;
	}
}
