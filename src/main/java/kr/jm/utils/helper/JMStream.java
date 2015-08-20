package kr.jm.utils.helper;

import static java.util.stream.Collectors.partitioningBy;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class JMStream {

	public static <T> Map<Boolean, List<T>> partitionBy(List<T> list,
			Predicate<? super T> predicate) {
		return list.stream().collect(partitioningBy(predicate));
	}

	public static <T> void consumeListByPredicate(List<T> list,
			Predicate<? super T> predicate, Consumer<? super T> trueConsumer,
			Consumer<? super T> falseConsumer) {
		list.forEach(target -> consumeByBoolean(predicate.test(target), target,
				trueConsumer, falseConsumer));
	}

	public static <T> void consumeListByPredicateInParallel(List<T> list,
			Predicate<? super T> predicate, Consumer<? super T> trueConsumer,
			Consumer<? super T> falseConsumer) {
		list.parallelStream().forEach(
				target -> consumeByBoolean(predicate.test(target), target,
						trueConsumer, falseConsumer));
	}

	public static <T> void consumeByBoolean(boolean bool, T target,
			Consumer<? super T> trueConsumer, Consumer<? super T> falseConsumer) {
		if (bool)
			trueConsumer.accept(target);
		else
			falseConsumer.accept(target);
	}
}
