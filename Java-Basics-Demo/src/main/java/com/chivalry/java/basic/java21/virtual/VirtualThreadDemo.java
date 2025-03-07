package com.chivalry.java.basic.java21.virtual;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * 虚拟线程示例
 * @author Mr.Zxb
 * @description
 * @date 2025/03/06 20:58
 */
public class VirtualThreadDemo {
    public static void main(String[] args) {
        // 通过Thread.ofVirtual()创建
        Runnable runnable = () -> {
            // code
            System.out.println(Thread.currentThread().getName() + "：创建线程");
        };

        Thread.ofVirtual().start(runnable);

        // 通过 Thread.startVirtualThread()创建
        Thread.startVirtualThread(runnable);

        // 通过 Executors.newVirtualThreadPerTaskExecutor() 创建
        var virtualThreadPerTaskExecutor = Executors.newVirtualThreadPerTaskExecutor();

        virtualThreadPerTaskExecutor.execute(runnable);

        LockSupport.park();
    }
}
