package kr.jm.utils.bundle;

import java.util.List;

public interface BundleInterface<T> {

	public abstract T getTarget(String targetId);

	public abstract List<String> getTargetIdList();

	public abstract boolean containsTargetId(String targetId);

	public abstract void removeTarget(String targetId) throws Exception;

	public abstract List<T> getTargetList();

}
