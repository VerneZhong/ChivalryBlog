package com.chivalry.java.concurrent.framework.locks;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-11-18 10:13
 */
public class AlternateOutputExamples {
    public static void main(String[] args) throws Exception {

        AtomicInteger ct = new AtomicInteger(0);

        Thread a = new Thread(() -> {
            try {
                while (ct.get() < 100) {
                    synchronized (ct) {
                        ct.notify();
                        ct.wait();
                        System.out.println(Thread.currentThread().getName() + " :" + ct.incrementAndGet());
                    }
                }
            } catch (InterruptedException e) {

            } finally {

            }

        }, "odd");

        Thread b = new Thread(() -> {
            try {
                while (ct.get() < 100) {
                    synchronized (ct) {
                        ct.notify();
                        ct.wait();
                        System.out.println(Thread.currentThread().getName() + " :" + ct.incrementAndGet());
                    }
                }
            } catch (InterruptedException e) {

            } finally {

            }
        }, "even");

        a.start();
        a.join(10);
        b.start();
    }
}
