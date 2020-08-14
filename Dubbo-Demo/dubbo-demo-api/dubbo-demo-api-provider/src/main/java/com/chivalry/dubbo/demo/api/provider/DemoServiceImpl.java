package com.chivalry.dubbo.demo.api.provider;

import com.chivalry.dubbo.demo.api.DemoService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-08-14 16:48
 */
public class DemoServiceImpl implements DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String sayHello(String message) {
        logger.info("Hello " + message + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + message + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
