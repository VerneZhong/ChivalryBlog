package com.chivalry.algorithm.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Mr.zxb
 * @date 2020-08-30 16:00:38
 */
public class Foo {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        stop();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        stop();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

    }

    public void third(Runnable printThird) throws InterruptedException {
        stop();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    private void stop() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
