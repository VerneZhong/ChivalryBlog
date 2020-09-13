package com.chivalry.spi.message;

import java.util.Optional;
import java.util.ServiceLoader;

/**
 * {@link ServiceLoader} 加载服务示例
 * @author Mr.zxb
 * @date 2020-09-11 23:53:02
 */
public class ServiceLoaderTest {
    public static void main(String[] args) {
        ServiceLoader<MessageServiceProvider> serviceProviders = ServiceLoader.load(MessageServiceProvider.class);

        // 遍历调用所有的实现类
        for (MessageServiceProvider serviceProvider : serviceProviders) {
            serviceProvider.sendMessage("Hello");
        }

        // 使用 Java 8 Optional 获取第一个 service，注意：findFirst()方法是JDK9版本提供的方法
//        Optional<MessageServiceProvider> firstService = serviceProviders.findFirst();
//        firstService.ifPresent(messageServiceProvider -> messageServiceProvider.sendMessage("Hello Friend"));

        // 使用 Java 8 forEach() 方法
        serviceProviders.forEach((service) -> service.sendMessage("Have a Nice Day!"));

        // 已加载服务总数
//        System.out.println(serviceProviders.stream().count());
    }
}
