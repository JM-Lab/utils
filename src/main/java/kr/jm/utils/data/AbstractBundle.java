package kr.jm.utils.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.jm.utils.spring.DestroyInterface;
import kr.jm.utils.spring.Destroyer;

public abstract class AbstractBundle<T extends DestroyInterface> implements
		BundleInterface<T> {

	protected Map<String, T> targetMap = new HashMap<String, T>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see kr.jm.utils.data.BundleInterface#getTarget(java.lang.String)
	 */
	@Override
	public T getTarget(String targetId) {
		return targetMap.get(targetId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kr.jm.utils.data.BundleInterface#getTargetIdList()
	 */
	@Override
	public List<String> getTargetIdList() {
		return new ArrayList<String>(targetMap.keySet());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kr.jm.utils.data.BundleInterface#containsTargetId(java.lang.String)
	 */
	@Override
	public boolean containsTargetId(String targetId) {
		return targetMap.keySet().contains(targetId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kr.jm.utils.data.BundleInterface#removeTarget(java.lang.String)
	 */
	@Override
	public void removeTarget(String targetId) throws Exception {
		getTarget(targetId).cleanUp();
		targetMap.remove(targetId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kr.jm.utils.data.BundleInterface#getTargetList()
	 */
	@Override
	public List<T> getTargetList() {
		return new ArrayList<T>(targetMap.values());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kr.jm.utils.data.BundleInterface#cleanUp()
	 */
	@Override
	public void cleanUp() throws RuntimeException {
		Destroyer.cleanUp(getTargetList());
	}

}
