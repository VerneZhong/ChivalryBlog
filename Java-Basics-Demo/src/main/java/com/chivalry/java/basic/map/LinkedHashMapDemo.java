package com.chivalry.java.basic.map;

import java.util.*;

/**
 * @author Mr.zxb
 * @date 2020-08-27 21:24:52
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // LinkedHashMap 默认按照插入顺序排序
//        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        // 设置为基于访问顺序排序
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put(2, "b");
        map.put(1, "a");
        map.put(4, "d");
        map.put(3, "c");
        map.put(5, "e");

        System.out.println("get()方法 前");
        print(map.entrySet().iterator());
        map.get(1);
        System.out.println("get()方法 后");
        print(map.entrySet().iterator());
    }

    private static void print(Iterator iterator) {
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iterator.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }
}
