package com.chivalry.java.basic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO Server
 *
 * @author Mr.zxb
 * @date 2020-09-08 14:29
 */
public class NioServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            Selector selector = Selector.open();
            serverSocketChannel.bind(new InetSocketAddress(8000));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                // 阻塞等待客户端Channel
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isConnectable()) {
                        System.out.println("接入新的客户端");
                    } else if (selectionKey.isReadable()) {
                        SocketChannel channel = serverSocketChannel.accept();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        // loop 读取客户端请求信息
                        StringBuilder request = new StringBuilder();
                        while (channel.read(byteBuffer) > 0) {
                            // 切换buffer为读模式
                            byteBuffer.flip();

                            // 读取buffer中的内容
                            request.append(StandardCharsets.UTF_8.decode(byteBuffer));
                        }
                        System.out.println(request);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
