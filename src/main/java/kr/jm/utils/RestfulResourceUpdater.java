package kr.jm.utils;

import static kr.jm.utils.helper.JMPredicate.getEquals;
import static kr.jm.utils.helper.JMPredicate.peek;

import java.util.Optional;
import java.util.function.Consumer;

import com.fasterxml.jackson.core.type.TypeReference;

import kr.jm.utils.helper.JMJson;
import kr.jm.utils.helper.JMOptional;
import kr.jm.utils.helper.JMRestfulResource;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RestfulResourceUpdater<T> {

	private String restfulResourceUrl;
	private String jsonStringCache;
	private TypeReference<T> type;

	public Optional<T> updateResource() {
		return JMOptional
				.getOptional(JMRestfulResource
						.getStringfromRestOrClasspathOrFilePath(
								restfulResourceUrl))
				.filter(getEquals(jsonStringCache).negate())
				.filter(peek(this::setJsonStringCache))
				.map(jsonString -> JMJson.fromJsonString(jsonString, type));
	}

	public void updateResource(Consumer<T> updateConsumer) {
		updateResource().ifPresent(updateConsumer);
	}

	private void setJsonStringCache(String jsonStringCache) {
		this.jsonStringCache = jsonStringCache;
	}

}
