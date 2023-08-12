package com.chivalry.java.concurrent.framework.locks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * {@link java.util.concurrent.CyclicBarrier} example class
 *
 * @author Mr.zxb
 * @date 2022-03-28 11:14
 */
public class CyclicBarrierExample {
    public static final int THREAD_COUNT = 500;

    public static void main(String[] args) {
        // 创建200个线程数的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        // 设置同步的线程数20
        CyclicBarrier cyclicBarrier = new CyclicBarrier(20);

        // 请求500次
        for (int i = 0; i < THREAD_COUNT; i++) {
            int num = i;
            executorService.execute(() -> {
                try {
                    System.out.printf("[%s] thread arrived here\n", Thread.currentThread().getName());
                    // 线程达到屏障
                    cyclicBarrier.await();
                    // 模拟业务请求
                    test(num);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        // 关闭线程池
        executorService.shutdown();
    }

    private static void test(int num) throws InterruptedException {
        Thread.sleep(1000);
        System.out.printf("[%s] thread count: %d\n", Thread.currentThread().getName(), num);
        Thread.sleep(1000);
    }
}
