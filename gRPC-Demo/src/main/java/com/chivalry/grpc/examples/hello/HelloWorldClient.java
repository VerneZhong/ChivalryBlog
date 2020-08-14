package com.chivalry.grpc.examples.hello;

import com.chivalry.grpc.examples.hello.HelloReply;
import com.chivalry.grpc.examples.hello.HelloRequest;
import com.chivalry.grpc.examples.hello.HelloWorldGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Hello World gRPC Client a {@code HelloServer}
 *
 * @author Mr.zxb
 * @date 2020-08-12 15:10
 */
public class HelloWorldClient {
    private static final Logger logger = Logger.getLogger(HelloWorldClient.class.getName());

    private final HelloWorldGrpc.HelloWorldBlockingStub blockingStub;

    public HelloWorldClient(Channel channel) {
        blockingStub = HelloWorldGrpc.newBlockingStub(channel);
    }

    /**
     * say hello to server
     * @param name
     */
    public void hello(String name) {
        logger.info("Will try to hello " + name + "...");
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply helloReply = blockingStub.sayHello(request);
        logger.info("result: " + helloReply.getMessage());
    }

    public static void main(String[] args) throws InterruptedException {
        String message = "world";
        // target server
        String target = "localhost:8080";

        // 创建到服务器的通信通道，称为通道。 通道是线程安全的并且可重用。
        // 通常在应用程序的开头创建通道并重复使用它们，直到应用程序关闭
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                // 默认情况下，通道是安全的（通过SSL / TLS）。 对于此示例，我们禁用TLS以避免需要证书。
//                .useTransportSecurity()
                .usePlaintext()
                .build();
        try {
            HelloWorldClient client = new HelloWorldClient(channel);
            client.hello(message);
        } finally {
            // 为防止内存泄露，在使用完将其关闭，在需要调用时直接使用
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
