package kr.jm.utils.spring;

import java.util.Arrays;
import java.util.List;

import kr.jm.utils.exception.JMExceptionManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Destroyer {

	public static <D extends DestroyInterface> void cleanUp(
			@SuppressWarnings("unchecked") D... destorys) {
		cleanUp(Arrays.asList(destorys));
	}

	public static <D extends DestroyInterface> void cleanUp(List<D> destroyList) {
		for (DestroyInterface destroyTarget : destroyList) {
			try {
				destroyTarget.cleanUp();
			} catch (Exception e) {
				JMExceptionManager.logException(log, e, "cleanUp",
						destroyTarget);
				continue;
			}
		}
	}
}
