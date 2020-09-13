package com.chivalry.java.basic.question;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Java7 try-with-resource 特性
 * @author Mr.zxb
 * @date 2020-09-13 11:20:22
 */
public class TryWithResourceDemo {
    public static void main(String[] args) {
        // 原始的try-catch-finally
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream("d:/temp.txt");
//            inputStream.read();
//        } catch (IOException e) {
//
//        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

//        tryWithResource();

        gotoMethod();
    }

    private static void tryWithResource() {
        // JDK7 提供的 try-with-resource 特性
        try (InputStream inputStream = new FileInputStream("d:/temp.txt");
             OutputStream outputStream = new FileOutputStream("d:/text.txt")) {
            inputStream.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void gotoMethod() {
        // goto
        stop:
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue stop;
            }
            System.out.println(i);
        }
    }
}
