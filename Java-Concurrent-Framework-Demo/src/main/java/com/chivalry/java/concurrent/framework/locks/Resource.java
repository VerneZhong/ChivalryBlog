package com.chivalry.java.concurrent.framework.locks;

/**
 * @author Mr.zxb
 * @date 2020-09-12 11:58:29
 */
public class Resource {
    public void doSomething() {
        // do some operation, DB read, write etc
    }

    public void doLogging() {
        // logging, no need for thread safety
    }
}
