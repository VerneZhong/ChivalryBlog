package com.chivalry.java.basic.feature;

import java.util.ArrayList;
import java.util.List;

public class Java9ListDemo {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("1", "2", "3"));
        strings.forEach(System.out::println);
        strings.add("4");
        strings.forEach(System.out::println);
    }
}
