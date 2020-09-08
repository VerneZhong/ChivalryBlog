package com.chivalry.java.basic.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

/**
 * AIO Client
 *
 * @author Mr.zxb
 * @date 2020-09-08 10:07
 */
public class AioClient {
    public static void main(String[] args) {
        try {
            AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
            socketChannel.connect(new InetSocketAddress(8080), null, new CompletionHandler<Void, Object>() {
                @Override
                public void completed(Void result, Object attachment) {
                    System.out.println("连接服务器成功...");
                    try {
                        // 给服务端发送数据，并等待完成
                        socketChannel.write(ByteBuffer.wrap("From Client: Hello I'm client.".getBytes())).get();
                        ByteBuffer allocate = ByteBuffer.allocate(128);
                        // 等待服务端发送的数据
                        socketChannel.read(allocate);
                        System.out.println(new String(allocate.array()));
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.out.println("出现异常：" + exc.getMessage());
                }
            });
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
