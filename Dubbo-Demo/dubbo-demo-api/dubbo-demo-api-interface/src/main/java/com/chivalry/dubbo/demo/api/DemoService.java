package com.chivalry.dubbo.demo.api;

import java.util.concurrent.CompletableFuture;

/**
 * interface
 *
 * @author Mr.zxb
 * @date 2020-08-14 16:17
 */
public interface DemoService {

    String sayHello(String message);

    /**
     * 异步请求
     * @param message
     * @return
     */
    default CompletableFuture<String> sayHelloAsync(String message) {
        return CompletableFuture.completedFuture(sayHello(message));
    }
}
