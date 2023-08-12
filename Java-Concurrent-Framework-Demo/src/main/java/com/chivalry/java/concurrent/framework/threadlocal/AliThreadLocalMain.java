package com.chivalry.java.concurrent.framework.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ali open source threadLocal {@link com.alibaba.ttl.TransmittableThreadLocal} examples
 *
 * @author Mr.zxb
 * @date 2022-04-22 13:51
 */
public class AliThreadLocalMain {

    public static void main(String[] args) {
//        ExecutorService executors = Executors.newFixedThreadPool(4);

        TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();
//        ThreadLocal<String> context = new InheritableThreadLocal<>();
//        ThreadLocal<String> context = new ThreadLocal<>();

        context.set("global config");

//        executors.execute(() -> System.out.println(context.get()));
//        executors.execute(() -> System.out.println(context.get()));

        CompletableFuture.runAsync(() -> System.out.println(context.get()));

//        executors.shutdown();
    }
}
