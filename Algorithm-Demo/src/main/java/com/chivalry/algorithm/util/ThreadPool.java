package com.chivalry.algorithm.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Mr.zxb
 * @date 2022-03-20 22:15
 */
public class ThreadPool {
    private static final ExecutorService EXECUTOR_SERVICE;
    static {
        int coreThreadSize = 5;
        int maxThreadSize = 10;
        EXECUTOR_SERVICE = new ThreadPoolExecutor(coreThreadSize, maxThreadSize, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1024));
    }

    public static ExecutorService getExecutorService() {
        return EXECUTOR_SERVICE;
    }
}
