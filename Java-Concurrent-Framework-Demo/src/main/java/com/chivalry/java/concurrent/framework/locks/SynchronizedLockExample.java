package com.chivalry.java.concurrent.framework.locks;

/**
 * synchronized 代码块来保证线程安全
 * @author Mr.zxb
 * @date 2020-09-12 12:01:24
 */
public class SynchronizedLockExample implements Runnable {

    private final Resource resource;

    public SynchronizedLockExample(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        // 数据库读写操作需要线程安全
        synchronized (resource) {
            resource.doSomething();
        }
        // 日志操作，无须线程安全
        resource.doLogging();
    }
}
