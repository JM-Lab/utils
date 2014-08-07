package kr.jm.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeoutExecutor {

	public static void run(final Runnable runnableWork, final long timeoutInSec) {
		final ExecutorService threadPool = Executors.newFixedThreadPool(2);
		threadPool.execute(runnableWork);
		afterTimeout(timeoutInSec, threadPool);
	}

	public static <T> Future<T> run(final Callable<T> callableWork,
			final long timeoutInSec) {
		final ExecutorService threadPool = Executors.newFixedThreadPool(2);
		Future<T> future = threadPool.submit(callableWork);
		afterTimeout(timeoutInSec, threadPool);
		return future;
	}

	private static void afterTimeout(final long timeoutInSec,
			final ExecutorService threadPool) {
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					if (!threadPool.awaitTermination(timeoutInSec,
							TimeUnit.SECONDS))
						threadPool.shutdownNow();
				} catch (InterruptedException e) {
					LogHelper.logExeption(log, e, "run", threadPool,
							timeoutInSec);
				} finally {
					if (!threadPool.isShutdown())
						threadPool.shutdownNow();
				}
			}
		});
	}
}
