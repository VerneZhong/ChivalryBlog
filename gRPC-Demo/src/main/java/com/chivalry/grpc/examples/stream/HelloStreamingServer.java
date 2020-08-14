package com.chivalry.grpc.examples.stream;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * hello stream gRPC Service
 *
 * @author Mr.zxb
 * @date 2020-08-12 16:31
 */
public class HelloStreamingServer {

    private static final Logger logger = Logger.getLogger(HelloStreamingServer.class.getName());

    static class OnReadyHandler implements Runnable {
        // 防止因onNext（）和onReady（）之间的竞争而导致虚假的onReady（）调用。
        // 如果在执行onNext（）时，但在onNext（）检查isReady（）之前，传输将isReady（）从false切换为true，
        // 则request（1）将被调用两次-一次由onNext（）调用，一次由计划的onReady（）调用 在onNext（）执行期间。
        private boolean wasReady = false;
        private final ServerCallStreamObserver<HelloReply> serverCallStreamObserver;

        public OnReadyHandler(ServerCallStreamObserver<HelloReply> serverCallStreamObserver) {
            this.serverCallStreamObserver = serverCallStreamObserver;
        }

        public void setWasReady(boolean wasReady) {
            this.wasReady = wasReady;
        }

        @Override
        public void run() {
            if (serverCallStreamObserver.isReady() && !wasReady) {
                wasReady = true;
                logger.info("Ready...");
                // 发信号通知请求发送者发送一条消息。 当isReady（）变为true时，就会发生这种情况，表示接收缓冲区有足够的可用空间来接收更多消息。
                // 调用request（）用于启动消息泵。
                serverCallStreamObserver.request(1);
            }
        }
    }

    /**
     * Service class implementation
     */
    static class HelloStreamingImpl extends HelloStreamingGrpc.HelloStreamingImplBase {
        @Override
        public StreamObserver<HelloRequest> sayHelloStreaming(StreamObserver<HelloReply> responseObserver) {
            // 为请求流设置手动流控制。 使用响应流的观察者来配置请求流的流控制是一种倒退的感觉，但是事实就是这样。
            ServerCallStreamObserver<HelloReply> serverCallStreamObserver =  (ServerCallStreamObserver<HelloReply>) responseObserver;
            serverCallStreamObserver.disableAutoRequest();

            OnReadyHandler onReadyHandler = new OnReadyHandler(serverCallStreamObserver);
            serverCallStreamObserver.setOnReadyHandler(onReadyHandler);

            // 给gRPC一个StreamObserver，它可以观察和处理传入的请求。
            return new StreamObserver<HelloRequest>() {
                @Override
                public void onNext(HelloRequest request) {
                    // 处理请求并发送响应或错误。
                    try {
                        // 接受并入队请求
                        String name = request.getName();
                        logger.info("---> " + name);

                        // 模拟服务器的“工作”
                        TimeUnit.MILLISECONDS.sleep(100);

                        // Send a response
                        String message = "Hello " + name;
                        HelloReply reply = HelloReply.newBuilder().setMessage(message).build();
                        logger.info("<--- " + message);
                        responseObserver.onNext(reply);

                        // 检查提供的ServerCallStreamObserver以查看它是否仍准备接受更多消息。
                        if (serverCallStreamObserver.isReady()) {
                            // 通知发件人发送另一个请求。 只要isReady（）保持为true，服务器将一直循环遍历onNext（）-> request（1）... onNext（）->
                            // request（1）...循环，直到客户端用尽消息并 结束循环（通过onCompleted（））。
                            // 如果在此处使用大于1的参数调用了request（），则服务器可能会耗尽接收缓冲区空间，并且isReady（）将变为false。
                            // 当接收缓冲区已充分耗尽时，isReady（）将变为true，并且将调用serverCallStreamObserver的onReadyHandler来重新启动消息泵。
                            serverCallStreamObserver.request(1);
                        } else {
                            // 如果不是，请注意背压已经开始。
                            onReadyHandler.setWasReady(false);
                        }
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                        responseObserver.onError(Status.UNKNOWN.withDescription("Error handling request").withCause(throwable).asException());
                    }
                }

                @Override
                public void onError(Throwable t) {
                    // End the response stream if the client presents an error.
                    t.printStackTrace();
                    responseObserver.onCompleted();
                }

                @Override
                public void onCompleted() {
                    // 当客户端结束请求流时，通知工作结束。
                    logger.info("COMPLETED");
                    responseObserver.onCompleted();
                }
            };
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50051;
        Server server = ServerBuilder.forPort(port)
                .addService(new HelloStreamingImpl())
                .build()
                .start();
        logger.info("Listening on " + server.getPort());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("Shutting down");
            try {
                server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        server.awaitTermination();
    }

}
