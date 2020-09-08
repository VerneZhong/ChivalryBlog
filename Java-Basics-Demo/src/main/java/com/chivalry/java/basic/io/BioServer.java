package com.chivalry.java.basic.io;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO Server
 *
 * @author Mr.zxb
 * @date 2020-09-08 10:51
 */
public class BioServer {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8000));
            System.out.println("Server 监听：" + 8000);
            while (true) {
                // 阻塞
                Socket socket = serverSocket.accept();
                System.out.println("新的客户端连接接入：" + socket.getRemoteSocketAddress().toString());
                socket.getOutputStream().write("From Server: I'm Server.".getBytes());
                // 多线程处理
                executorService.execute(() -> {
                    while (true) {
                        try {
                            InputStream inputStream = socket.getInputStream();
                            // 读取客户端发送的数据
                            byte[] bytes = new byte[1024];
                            inputStream.read(bytes);
                            System.out.println("等待读取数据...");
                            System.out.println(new String(bytes));
                            PrintWriter printWriter =
                                    new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
                            printWriter.write("From Server:" + new String(bytes));
                            printWriter.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
