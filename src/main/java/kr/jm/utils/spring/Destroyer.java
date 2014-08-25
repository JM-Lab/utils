package kr.jm.utils.spring;

import java.util.Arrays;
import java.util.List;

import kr.jm.utils.LogHelper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Destroyer {

	public static <D extends DestroyInterface> void cleanUp(D... destoryList) {
		cleanUp(Arrays.asList(destoryList));
	}

	public static <D extends DestroyInterface> void cleanUp(List<D> destoryList) {
		for (DestroyInterface destroyTarget : destoryList) {
			try {
				destroyTarget.cleanUp();
			} catch (Exception e) {
				LogHelper.logExeption(log, e, "cleanUp", destroyTarget);
				continue;
			}
		}
	}
}