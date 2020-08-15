package com.chivalry.design.patterns.singleton;

/**
 * 单例模式
 * @author Mr.zxb
 * @date 2020-08-15 21:17:31
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {}


    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
