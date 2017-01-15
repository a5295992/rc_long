package com.rc_long.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.rc_long.ThreadPool.MyTask;

public class ThreadPoolsUtils {

	public static void execute(MyTask mt) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
			executor.execute(mt);
			executor.shutdown();
	}

}
