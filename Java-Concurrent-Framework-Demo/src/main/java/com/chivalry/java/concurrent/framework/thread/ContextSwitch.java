package com.chivalry.java.concurrent.framework.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.LockSupport;

/**
 * Thread Context switch class
 * The fewer threads are speedier than more threads
 *
 * @author Mr.zxb
 * @date 2022-03-18 10:46
 */
public class ContextSwitch {

    public static final int CUPS = Runtime.getRuntime().availableProcessors();

    public static final ExecutorService EXECUTORS = Executors.newFixedThreadPool(100);
    public static final ExecutorService EXECUTORS2 = Executors.newFixedThreadPool(CUPS);

    public static void testContextSwitch() {
        long start = System.currentTimeMillis();
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<?> future = EXECUTORS.submit(() -> {
//                LockSupport.parkNanos(5000);
//                System.out.println("testContextSwitch " + Thread.currentThread().getName() + " end.");
            });
            futures.add(future);
        }
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("testContextSwitch end cost time = " + end + "ms");
    }

    public static void testNoContextSwitch() {
        long start = System.currentTimeMillis();
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<?> future = EXECUTORS2.submit(() -> {
//                LockSupport.parkNanos(5000);
//                System.out.println("testNoContextSwitch " + Thread.currentThread().getName() + " end.");
            });
            futures.add(future);
        }
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("testNoContextSwitch end cost time = " + end + "ms");
    }

    public static void main(String[] args) {
        testContextSwitch();
        testNoContextSwitch();
    }
}
