package com.chivalry.java.basic.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

/**
 * AIO Server
 *
 * @author Mr.zxb
 * @date 2020-09-08 09:36
 */
public class AioServer {
    public static void main(String[] args) {
        try {
            AsynchronousServerSocketChannel socketChannel = AsynchronousServerSocketChannel.open();
            socketChannel.bind(new InetSocketAddress(8080));

            socketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
                @Override
                public void completed(AsynchronousSocketChannel result, Object attachment) {
                    // 继续监听下一个请求
                    socketChannel.accept(attachment, this);
                    handler(result);
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.out.println("服务出现异常：" + exc.getMessage());
                }
            });
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handler(AsynchronousSocketChannel result) {
        try {
            System.out.println("接入新的客户端：" + result.getRemoteAddress().toString());
            // 给客户端发送数据并等待发送完成
            result.write(ByteBuffer.wrap("From Server: Hello I am server".getBytes())).get();

            ByteBuffer allocate = ByteBuffer.allocate(128);
            // 阻塞等待客户端接收数据
            result.read(allocate).get();

            System.out.println(new String(allocate.array()));
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
