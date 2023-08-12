package com.chivalry.java.concurrent.framework.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link ThreadLocal} example
 * @author Mr.zxb
 * @date 2022-04-07 21:20
 */
public class ThreadLocalTest {
    private List<String> list = new ArrayList<>();

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().list.add(message);
    }

    public static List<String> clear() {
        List<String> list = holder.get().list;
        holder.remove();

        System.out.println("size: " + holder.get().list.size());
        return list;
    }

    public static void main(String[] args) {
        ThreadLocalTest.add("test");
        System.out.println(holder.get().list);
        ThreadLocalTest.clear();
    }
}
