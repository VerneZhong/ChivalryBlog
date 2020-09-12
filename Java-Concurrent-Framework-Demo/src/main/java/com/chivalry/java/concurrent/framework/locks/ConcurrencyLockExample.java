package com.chivalry.java.concurrent.framework.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于Java Lock API {@link java.util.concurrent.locks.ReentrantLock} 来实现线程安全的示例
 *
 * @author Mr.zxb
 * @date 2020-09-12 12:05:44
 */
public class ConcurrencyLockExample implements Runnable {
    private final Resource resource;

    private Lock lock;

    public ConcurrencyLockExample(Resource resource) {
        this.resource = resource;
        // 默认创建非公平锁
        this.lock = new ReentrantLock();
    }


    @Override
    public void run() {
        try {
            // 等待获取锁
            if (lock.tryLock(10, TimeUnit.SECONDS)) {
                resource.doSomething();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
        resource.doLogging();
    }
}
