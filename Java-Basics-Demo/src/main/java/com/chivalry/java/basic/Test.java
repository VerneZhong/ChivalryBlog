package com.chivalry.java.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-09-10 14:09
 */
public class Test {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        // 初始化10个线程计数
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 100; i1++) {
                        integer.incrementAndGet();
                    }
                    // 线程执行一次就 -1
                    latch.countDown();
                }
            }).start();
        }
        try {
            // 直到为0的时候，会继续向下执行
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(integer.get());
    }
}
