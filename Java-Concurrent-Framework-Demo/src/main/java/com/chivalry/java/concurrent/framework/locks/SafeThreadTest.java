package com.chivalry.java.concurrent.framework.locks;

/**
 * 线程安全的类，使用synchronized关键字来保证线程安全
 * @author Mr.zxb
 * @date 2020-09-12 11:53:37
 */
public class SafeThreadTest {
    public synchronized void foo() {
        // do something
        bar();
    }

    public synchronized void bar() {
        // do some more
    }
}
