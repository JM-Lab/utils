package kr.jm.utils.data;

import java.util.List;

import kr.jm.utils.spring.DestroyInterface;

public interface BundleInterface<T extends DestroyInterface> extends
		DestroyInterface {

	public abstract T getTarget(String targetId);

	public abstract List<String> getTargetIdList();

	public abstract boolean containsTargetId(String targetId);

	public abstract void removeTarget(String targetId) throws Exception;

	public abstract List<T> getTargetList();

	public abstract void cleanUp() throws RuntimeException;

}