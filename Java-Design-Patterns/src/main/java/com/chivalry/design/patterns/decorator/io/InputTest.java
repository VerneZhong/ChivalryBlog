package com.chivalry.design.patterns.decorator.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 测试新的Java I/O 装饰者
 *
 * @author Mr.zxb
 * @date 2020-08-13 22:10:31
 */
public class InputTest {
    public static void main(String[] args) throws IOException {
        int c;
        InputStream in = null;
        try {
            // 设置 InputStream，先用 BufferedInputStream装饰它，再用我们新的 LowerCaseInputStream过滤器装饰
            in = new LowerCaseInputStream(new BufferedInputStream(System.in));
            while ((c = in.read()) > 0) {
                System.out.print("结果：" +(char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
