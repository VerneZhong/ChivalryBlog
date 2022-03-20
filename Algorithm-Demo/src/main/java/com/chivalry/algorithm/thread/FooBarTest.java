package com.chivalry.algorithm.thread;

import static com.chivalry.algorithm.util.ThreadPool.getExecutorService;

/**
 * @author Mr.zxb
 * @date 2022-03-20 22:14
 */
public class FooBarTest {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);

        getExecutorService().execute(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        getExecutorService().execute(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
