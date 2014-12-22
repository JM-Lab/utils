package kr.jm.utils.bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.jm.utils.spring.DestroyInterface;
import kr.jm.utils.spring.Destroyer;

public abstract class AbstractBundle<T extends DestroyInterface> implements
		BundleInterface<T> {

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
		getTarget(targetId).cleanUp();
		targetMap.remove(targetId);
	}

	@Override
	public List<T> getTargetList() {
		return new ArrayList<T>(targetMap.values());
	}

	@Override
	public void cleanUp() throws RuntimeException {
		Destroyer.cleanUp(getTargetList());
	}

}
