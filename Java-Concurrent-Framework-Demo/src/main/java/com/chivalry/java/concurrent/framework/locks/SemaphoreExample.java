package com.chivalry.java.concurrent.framework.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * {@link java.util.concurrent.Semaphore} example class
 *
 * @author Mr.zxb
 * @date 2022-03-28 10:32
 */
public class SemaphoreExample {

    public static final int THREAD_COUNT = 500;

    public static void main(String[] args) {
        // 创建200个线程数的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        // 设置20个许可证的信号量
        Semaphore semaphore = new Semaphore(20);

        // 请求500次
        for (int i = 0; i < THREAD_COUNT; i++) {
            int num = i;
            executorService.execute(() -> {
                try {
                    // 获取许可证
                    semaphore.acquire();
                    // 模拟业务请求
                    test(num);
                    // 释放许可证
                    semaphore.release();
                } catch (InterruptedException e) {
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
