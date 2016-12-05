package kr.jm.utils;

import static kr.jm.utils.helper.JMPredicate.getEquals;
import static kr.jm.utils.helper.JMPredicate.peek;

import java.util.Optional;
import java.util.function.Consumer;

import com.fasterxml.jackson.core.type.TypeReference;

import kr.jm.utils.helper.JMJson;
import kr.jm.utils.helper.JMOptional;
import kr.jm.utils.helper.JMRestfulResource;
import lombok.Getter;

/**
 * The Class RestfulResourceUpdater.
 *
 * @param <T>
 *            the generic type
 */
@Getter
public class RestfulResourceUpdater<T> {

	private String restfulResourceUrl;
	private TypeReference<T> type;
	private String cachedJsonString;
	private T cachedResource;

	/**
	 * Instantiates a new restful resource updater.
	 *
	 * @param restfulResourceUrl
	 *            the restful resource url
	 * @param type
	 *            the type
	 */
	public RestfulResourceUpdater(String restfulResourceUrl,
			TypeReference<T> type) {
		super();
		this.restfulResourceUrl = restfulResourceUrl;
		this.type = type;
	}

	/**
	 * Update resource.
	 *
	 * @return the optional
	 */
	public Optional<T> updateResource() {
		return JMOptional.getOptional(JMRestfulResource
				.getStringfromRestOrClasspathOrFilePath(restfulResourceUrl))
				.filter(getEquals(cachedJsonString).negate())
				.filter(peek(this::setJsonStringCache))
				.map(jsonString -> JMJson.fromJsonString(jsonString, type))
				.filter(peek(resource -> this.cachedResource = resource));
	}

	/**
	 * Update resource.
	 *
	 * @param updateConsumer
	 *            the update consumer
	 */
	public void updateResource(Consumer<T> updateConsumer) {
		updateResource().ifPresent(updateConsumer);
	}

	private void setJsonStringCache(String jsonStringCache) {
		this.cachedJsonString = jsonStringCache;
	}
}
