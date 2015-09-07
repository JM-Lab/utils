package kr.jm.utils.bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBundle<T> implements BundleInterface<T> {

	protected Map<String, T> targetMap = new HashMap<String, T>();

	@Override
	public T getTarget(String targetId) {
		return targetMap.get(targetId);
	}

	@Override
	public List<String> getTargetIdList() {
		return new ArrayList<String>(targetMap.keySet());
	}

	@Override
	public boolean containsTargetId(String targetId) {
		return targetMap.keySet().contains(targetId);
	}

	@Override
	public void removeTarget(String targetId) throws Exception {
		targetMap.remove(targetId);
	}

	@Override
	public List<T> getTargetList() {
		return new ArrayList<T>(targetMap.values());
	}

}
