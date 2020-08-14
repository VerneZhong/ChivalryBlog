package com.chivalry.grpc.examples.stream;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientResponseObserver;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Hello stream gRPC Client
 *
 * @author Mr.zxb
 * @date 2020-08-13 10:29
 */
public class HelloStreamingClient {
    private static final Logger logger = Logger.getLogger(HelloStreamingClient.class.getName());

    private final HelloStreamingGrpc.HelloStreamingStub stub;

    private final CountDownLatch done = new CountDownLatch(1);

    public HelloStreamingClient(Channel channel) {
        this.stub = HelloStreamingGrpc.newStub(channel);
    }

    private void sendHelloStreaming() throws InterruptedException {
        // Note: clientResponseObserver is handling both request and response stream processing.
        stub.sayHelloStreaming(new ClientResponseObserverImpl(done));
        done.await();
    }

    static class ClientResponseObserverImpl implements ClientResponseObserver<HelloRequest, HelloReply> {

        private final CountDownLatch done;

        private ClientCallStreamObserver<HelloRequest> callStreamObserver;

        public ClientResponseObserverImpl(CountDownLatch done) {
            this.done = done;
        }

        @Override
        public void beforeStart(ClientCallStreamObserver<HelloRequest> requestStream) {
            this.callStreamObserver = requestStream;
            // 为响应流设置手动流控制。使用请求流的观察者来配置响应流的流控制是一种倒退的感觉，但是事实就是这样。
            callStreamObserver.disableAutoRequestWithInitial(1);
            callStreamObserver.setOnReadyHandler(new OnReadyHandler(callStreamObserver));
        }

        @Override
        public void onNext(HelloReply value) {
            logger.info("<--- " + value.getMessage());
            // Signal the sender to send one message.
            callStreamObserver.request(1);
        }

        @Override
        public void onError(Throwable t) {
            t.printStackTrace();
            done.countDown();
        }

        @Override
        public void onCompleted() {
            logger.info("All Done.");
            done.countDown();
        }
    }

    static class OnReadyHandler implements Runnable {

        // An iterator is used so we can pause and resume iteration of the request data.
        private Iterator<String> iterator = names().iterator();

        private final ClientCallStreamObserver<HelloRequest> requestStream;

        public OnReadyHandler(ClientCallStreamObserver<HelloRequest> requestStream) {
            this.requestStream = requestStream;
        }

        @Override
        public void run() {
            // Start generating values from where we left off on a non-gRPC thread.
            while (requestStream.isReady()) {
                if (iterator.hasNext()) {
                    // Send more messages if there are more messages to send
                    String name = iterator.next();
                    logger.info("---> " + name);
                    HelloRequest request = HelloRequest.newBuilder().setName(name).build();
                    requestStream.onNext(request);
                } else {
                    // Signal completion if there is nothing left to send.
                    requestStream.onCompleted();
                }
            }
        }
    }

    private static List<String> names() {
        return Arrays.asList(
                "Sophia", "Jackson", "Emma", "Aiden", "Olivia", "Lucas", "Ava", "Liam", "Mia", "Noah",
                "Isabella", "Ethan", "Riley", "Mason", "Aria", "Caden", "Zoe", "Oliver", "Charlotte",
                "Elijah", "Lily", "Grayson", "Layla", "Jacob", "Amelia", "Michael", "Emily", "Benjamin",
                "Madelyn", "Carter", "Aubrey", "James", "Adalyn", "Jayden", "Madison", "Logan", "Chloe",
                "Alexander", "Harper", "Caleb", "Abigail", "Ryan", "Aaliyah", "Luke", "Avery", "Daniel",
                "Evelyn", "Jack", "Kaylee", "William", "Ella", "Owen", "Ellie", "Gabriel", "Scarlett",
                "Matthew", "Arianna", "Connor", "Hailey", "Jayce", "Nora", "Isaac", "Addison", "Sebastian",
                "Brooklyn", "Henry", "Hannah", "Muhammad", "Mila", "Cameron", "Leah", "Wyatt", "Elizabeth",
                "Dylan", "Sarah", "Nathan", "Eliana", "Nicholas", "Mackenzie", "Julian", "Peyton", "Eli",
                "Maria", "Levi", "Grace", "Isaiah"
        );
    }

    public static void main(String[] args) throws InterruptedException {
        // Create a channel and a stub
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // create HelloStreamingClient new instance
        com.chivalry.grpc.examples.stream.HelloStreamingClient streamingClient = new com.chivalry.grpc.examples.stream.HelloStreamingClient(channel);

        // send stream data
        streamingClient.sendHelloStreaming();

        channel.shutdown();
        channel.awaitTermination(1, TimeUnit.SECONDS);
    }
}
