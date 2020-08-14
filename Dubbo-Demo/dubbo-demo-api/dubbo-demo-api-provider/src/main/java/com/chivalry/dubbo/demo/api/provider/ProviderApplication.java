package com.chivalry.dubbo.demo.api.provider;


import com.chivalry.dubbo.demo.api.DemoService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;

/**
 * Dubbo Demo Provider
 *
 * @author Mr.zxb
 * @date 2020-08-14 16:11
 */
public class ProviderApplication {
    public static void main(String[] args) {
        ServiceConfig<DemoServiceImpl> service = new ServiceConfig<>();
        service.setInterface(DemoService.class);
        service.setRef(new DemoServiceImpl());

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("dubbo-demo-api-provider"))
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .service(service)
                .start()
                .await();
    }
}
