package com.chivalry.java.concurrent.framework.daemon;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程示例
 *
 * @author Mr.zxb
 * @date 2020-09-16 14:10
 */
public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(123);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(false);

        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(456);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(false);
        thread.start();
        thread2.start();
    }
}
