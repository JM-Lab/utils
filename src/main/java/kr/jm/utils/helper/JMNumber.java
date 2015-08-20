package kr.jm.utils.helper;

import java.util.List;

public class JMNumber {

	public static <N extends Number> Number min(List<N> numberList) {
		return JMCollections.isNullOrEmpty(numberList) ? 0
				: numberList.get(0) instanceof Integer ? numberList.stream()
						.mapToInt(Number::intValue).min().orElse(0)
						: numberList.get(0) instanceof Long ? numberList
								.stream().mapToLong(Number::longValue).min()
								.orElse(0) : numberList.stream()
								.mapToDouble(Number::doubleValue).min()
								.orElse(0);
	}

	public static <N extends Number> Number max(List<N> numberList) {
		return JMCollections.isNullOrEmpty(numberList) ? 0
				: numberList.get(0) instanceof Integer ? numberList.stream()
						.mapToInt(Number::intValue).max().orElse(0)
						: numberList.get(0) instanceof Long ? numberList
								.stream().mapToLong(Number::longValue).max()
								.orElse(0) : numberList.stream()
								.mapToDouble(Number::doubleValue).max()
								.orElse(0);
	}

	public static Number count(List<?> numberList) {
		return numberList.size();
	}

	public static <N extends Number> Number sum(List<N> numberList) {
		return JMCollections.isNullOrEmpty(numberList) ? 0
				: numberList.get(0) instanceof Integer ? numberList.stream()
						.mapToInt(Number::intValue).sum()
						: numberList.get(0) instanceof Long ? numberList
								.stream().mapToLong(Number::longValue).sum()
								: numberList.stream()
										.mapToDouble(Number::doubleValue).sum();
	}

	public static <N extends Number> Number average(List<N> numberList) {
		return JMCollections.isNullOrEmpty(numberList) ? 0
				: numberList.get(0) instanceof Integer ? numberList.stream()
						.mapToInt(Number::intValue).average().orElse(0)
						: numberList.get(0) instanceof Long ? numberList
								.stream().mapToLong(Number::longValue)
								.average().orElse(0) : numberList.stream()
								.mapToDouble(Number::doubleValue).average()
								.orElse(0);
	}

}
