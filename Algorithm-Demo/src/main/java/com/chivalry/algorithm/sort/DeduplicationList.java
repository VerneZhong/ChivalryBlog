package com.chivalry.algorithm.sort;

import java.util.*;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-08-20 15:51
 */
public class DeduplicationList {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 6);

        List<String> strings = Arrays.asList("2", "2", "a", "a");

        deduplicationList(list).forEach(System.out::print);

        deduplicationList(strings).forEach(System.out::print);
    }

    public static <T> List<T> deduplicationList(List<T> list) {
        return new ArrayList<>(new HashSet<>(list));
    }
}
