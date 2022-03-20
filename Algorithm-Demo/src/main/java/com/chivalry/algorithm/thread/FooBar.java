package com.chivalry.algorithm.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印 FooBar
 * @author Mr.zxb
 * @date 2022-03-20 22:11
 */
public class FooBar {
    private int n;

    private final ReentrantLock lock = new ReentrantLock();

    private final Condition condition = lock.newCondition();

    private volatile boolean isModify = false;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (isModify) {
                    condition.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isModify = true;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!isModify) {
                    condition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isModify = false;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

}
