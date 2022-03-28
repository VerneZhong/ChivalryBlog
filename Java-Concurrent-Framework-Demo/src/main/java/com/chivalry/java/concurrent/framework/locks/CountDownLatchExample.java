package com.chivalry.java.concurrent.framework.locks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * {@link java.util.concurrent.CountDownLatch} example class
 *
 * @author Mr.zxb
 * @date 2022-03-28 11:07
 */
public class CountDownLatchExample {
    public static final int THREAD_COUNT = 500;

    public static void main(String[] args) throws InterruptedException {
        // 创建200个线程数的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        // 设置20个许可证的信号量
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

        // 请求500次
        for (int i = 0; i < THREAD_COUNT; i++) {
            int num = i;
            executorService.execute(() -> {
                try {
                    // 模拟业务请求
                    test(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放资源
                    countDownLatch.countDown();
                }
            });
        }
        // 等待所有任务完成
        countDownLatch.await();
        // 关闭线程池
        executorService.shutdown();
        System.out.println("all task finished");
    }

    private static void test(int num) throws InterruptedException {
        Thread.sleep(1000);
        System.out.printf("[%s] thread count: %d\n", Thread.currentThread().getName(), num);
        Thread.sleep(1000);
    }
}
