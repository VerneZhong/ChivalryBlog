package com.chivalry.java.basic;

import java.util.*;

/**
 * @author Mr.zxb
 * @date 2020-08-27 21:24:52
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();
//        Map<Integer, String> map = new HashMap<>();
        map.put(2, "b");
        map.put(1, "a");
        map.put(4, "d");
        map.put(3, "c");
        map.put(5, "e");

        Set<Map.Entry<Integer, String>> set = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            System.out.printf("k = %s ,v = %s\n", entry.getKey(), entry.getValue());
//        }
    }
}
