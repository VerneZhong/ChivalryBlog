package com.chivalry.java.concurrent.framework.queue;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * {@link java.util.concurrent.CopyOnWriteArrayList} example class
 * 适用于读多写少的场景
 *
 * @author Mr.zxb
 * @date 2022-03-24 10:08
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);
//        testCopyOnWriteArrayList(executor);
        testReentrantReadWriteLock(executor);
        executor.shutdown();
    }

    public static void testCopyOnWriteArrayList(ExecutorService executor) {
        long start = System.currentTimeMillis();
        CopyOnWriteArrayList<Integer> arrayList = new CopyOnWriteArrayList<>();
        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                arrayList.add(i);
            }
        });
        for (int i = 0; i < 9; i++) {
            executor.execute(() -> {
                Integer result = arrayList.get(arrayList.size() - 1);
                System.out.println("result: " + result);
            });
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("cost time: " + end + " ms");
    }

    public static void testReentrantReadWriteLock(ExecutorService executor) {
        long start = System.currentTimeMillis();
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ArrayList<Integer> arrayList = new ArrayList<>();
        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                ReentrantReadWriteLock.WriteLock lock = readWriteLock.writeLock();
                lock.lock();
                try {
                    arrayList.add(i);
                } finally {
                    lock.unlock();
                }
            }
        });
        for (int i = 0; i < 9; i++) {
            executor.execute(() -> {
                ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
                readLock.lock();
                try {
                    Integer result = arrayList.get(arrayList.size() - 1);
                    System.out.println("result: " + result);
                } finally {
                    readLock.unlock();
                }
            });
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("cost time: " + end + " ms");
    }
}
