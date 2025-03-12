package com.chivalry.java.basic.java21.sequenced;

import java.util.*;

/**
 * 序列化集合示例
 * @author Mr.Zxb
 * @description
 * @date 2025/03/12 20:58
 */
public class SequenceCollectionDemo {
    public static void main(String[] args) {
        arrayListTest();
        linkedHashSetTest();
        linkedHashMapTest();
    }

    private static void linkedHashMapTest() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        Map.Entry<Integer, String> firstEntry = map.firstEntry();
        System.out.println(firstEntry);
        Map.Entry<Integer, String> lastEntry = map.lastEntry();
        System.out.println(lastEntry);

        System.out.println(map);

        Map.Entry<Integer, String> pollFirstEntry = map.pollFirstEntry();
        System.out.println(pollFirstEntry);
        Map.Entry<Integer, String> polledLastEntry = map.pollLastEntry();
        System.out.println(polledLastEntry);

        System.out.println(map);
        map.putFirst(1, "a");
        map.putLast(3, "c");
        System.out.println(map);
        System.out.println(map.reversed());
    }

    private static void linkedHashSetTest() {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(List.of(1, 2, 3));

        Integer first = linkedHashSet.getFirst();
        System.out.println(STR."first = \{first}");
        Integer last = linkedHashSet.getLast();
        System.out.println(STR."last = \{last}");

        linkedHashSet.addFirst(0);
        linkedHashSet.addLast(4);

        System.out.println(linkedHashSet);

        SequencedSet<Integer> reversed = linkedHashSet.reversed();
        System.out.println(reversed);
    }

    private static void arrayListTest() {
        List<Integer> arrayList = new ArrayList<>();

        // List Contains【1】
        arrayList.add(1);

        arrayList.addFirst(0);
        arrayList.addLast(2);

        Integer firstElement = arrayList.getFirst();
        System.out.println(STR."firstElement = \{firstElement}");
        Integer lastElement = arrayList.getLast();
        System.out.println(STR."firstElement = \{lastElement}");

        // List Contains【0, 1, 2】
        System.out.println(arrayList);

        List<Integer> reversed = arrayList.reversed();
        System.out.println(reversed);
    }
}
