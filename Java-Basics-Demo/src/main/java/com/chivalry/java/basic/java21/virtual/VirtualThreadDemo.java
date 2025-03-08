package com.chivalry.java.basic.java21.virtual;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * 虚拟线程示例
 * @author Mr.Zxb
 * @description
 * @date 2025/03/06 20:58
 */
public class VirtualThreadDemo {
    public static void main(String[] args) throws InterruptedException {

        int threadCount = 3;
        CountDownLatch latch = new CountDownLatch(threadCount);

        // 通过Thread.ofVirtual()创建
        Runnable runnable1 = () -> {
            // code
            System.out.println(Thread.currentThread().getName() + "：创建线程");
            latch.countDown();
        };

        Runnable runnable2 = () -> {
            // code
            System.out.println(Thread.currentThread().getName() + "：创建线程");
            latch.countDown();
        };

        Runnable runnable3 = () -> {
            // code
            System.out.println(Thread.currentThread().getName() + "：创建线程");
            latch.countDown();
        };

        Thread.ofVirtual().name("MyVirtualThread").start(runnable1);

        // 通过 Thread.startVirtualThread()创建
        Thread.startVirtualThread(runnable2).setName("MyVirtualThread");

        // 通过 Executors.newVirtualThreadPerTaskExecutor() 创建
        var virtualThreadPerTaskExecutor = Executors.newVirtualThreadPerTaskExecutor();

        virtualThreadPerTaskExecutor.execute(runnable3);

        latch.await();
    }
}
