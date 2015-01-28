package kr.jm.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolHelper {
	public static ExecutorService newThreadPool(int numOfThread) {
		return numOfThread < 1 ? Executors.newCachedThreadPool() : Executors
				.newFixedThreadPool(numOfThread);
	}
}
