package com.chivalry.algorithm.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 * source LeetCode
 * @link  https://leetcode-cn.com/problems/print-in-order
 * @author Mr.zxb
 * @date 2020-08-30 16:00:38
 */
public class Foo {

    private final CountDownLatch count1 = new CountDownLatch(1);
    private final CountDownLatch count2 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        count1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        count2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        count2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }


}
