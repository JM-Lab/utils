package kr.jm.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeoutExecutor {
	public static void run(ExecutorService threadPool, final Runnable runnableWork, final long timeoutInSec) {
		threadPool.execute(runnableWork);
		afterTimeout(timeoutInSec, threadPool);
	}

	public static void run(final Runnable runnableWork, final long timeoutInSec) {
		final ExecutorService threadPool = Executors.newFixedThreadPool(2);
		run(threadPool, runnableWork, timeoutInSec);
	}
	
	public static <T> Future<T> run(ExecutorService threadPool, final Callable<T> callableWork,
			final long timeoutInSec) {
		Future<T> future = threadPool.submit(callableWork);
		afterTimeout(timeoutInSec, threadPool);
		return future;
	}

	public static <T> Future<T> run(final Callable<T> callableWork,
			final long timeoutInSec) {
		final ExecutorService threadPool = Executors.newFixedThreadPool(2);
		return run(threadPool, callableWork, timeoutInSec);
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
