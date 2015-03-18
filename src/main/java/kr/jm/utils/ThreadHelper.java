package kr.jm.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadHelper {
	public static ExecutorService newThreadPool(int numOfThread) {
		return numOfThread < 1 ? Executors.newCachedThreadPool() : Executors
				.newFixedThreadPool(numOfThread);
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
