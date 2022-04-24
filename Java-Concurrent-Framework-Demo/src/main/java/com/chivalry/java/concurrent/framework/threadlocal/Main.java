package com.chivalry.java.concurrent.framework.threadlocal;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2022-04-19 13:58
 */
public class Main {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        // 子线程共享父线程中创建的线程副本数据
        ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        threadLocal.set("main threadLocal");
        inheritableThreadLocal.set("main inheritable threadLocal");

        Thread newThread = new Thread(() -> System.out.println("child thread: " + threadLocal.get()));
        Thread newThread2 = new Thread(() -> System.out.println("child2 thread: " + inheritableThreadLocal.get()));

        newThread.start();
        newThread2.start();
    }
}
