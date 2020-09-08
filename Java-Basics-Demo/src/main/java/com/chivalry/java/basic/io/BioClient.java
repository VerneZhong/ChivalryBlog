package com.chivalry.java.basic.io;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * BIO Client
 *
 * @author Mr.zxb
 * @date 2020-09-08 10:51
 */
public class BioClient {
    public static void main(String[] args) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(8000));
            System.out.println("连接到服务端");
            while (true) {
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[128];
                // 读取客户端发送的数据
                inputStream.read(bytes);
                System.out.println(new String(bytes));

                PrintWriter printWriter =
                        new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
                byte[] bytes2 = new byte[128];
                System.in.read(bytes2);
                printWriter.write("From Client:" + new String(bytes2));
                printWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
