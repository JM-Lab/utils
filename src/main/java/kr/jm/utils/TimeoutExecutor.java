package kr.jm.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TimeoutExecutor {
	public static void run(final Runnable runnableWork, final long timeoutInSec) {
		final ExecutorService threadPool = Executors.newFixedThreadPool(2);
		afterTimeout(timeoutInSec, threadPool, threadPool.submit(runnableWork));
	}

	private static void afterTimeout(final long timeoutInSec,
			final ExecutorService threadPool, final Future<?> future) {
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					future.get(timeoutInSec, TimeUnit.SECONDS);
				} catch (Exception e) {
					throw new RuntimeException(e);
				} finally {
					if (!threadPool.isShutdown())
						threadPool.shutdownNow();
				}
			}
		});
	}

	public static <T> Future<T> run(final Callable<T> callableWork,
			final long timeoutInSec) {
		final ExecutorService threadPool = Executors.newFixedThreadPool(2);
		Future<T> future = threadPool.submit(callableWork);
		afterTimeout(timeoutInSec, threadPool, future);
		return future;
	}
}
