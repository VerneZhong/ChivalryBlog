package com.chivalry.java.basic.function;

import java.util.HashMap;
import java.util.function.*;
import java.util.function.Consumer;

/**
 * @author Mr.zxb
 * @date 2020-09-13 19:55:21
 */
public class Main {
    public static void main(String[] args) {
        // JDK 8  Supplier Consumer Function Predicate
        Predicate<Integer> predicate = i -> i == 2;
        System.out.println(predicate.test(2));

        // 创建对象
        Supplier<String> supplier = () -> "supplier";
        System.out.println(supplier.get());

//        Supplier<HashMap> hashMapSupplier = () -> new HashMap();
        Supplier<HashMap> hashMapSupplier = HashMap::new;
        System.out.println(hashMapSupplier.get());

        hashMapSupplier.get().forEach((k, v) -> {
            System.out.println("K = " + k + ", V = " + v);
        });

//        Consumer<String> consumer = s -> System.out.println(s + " world");
        Consumer<String> consumer = s -> System.out.println(s + " world");
        consumer.accept("hello");

        BiConsumer<String, String> biConsumer = (k, v) -> System.out.println("K = " + k + ", V = " + v);
        biConsumer.accept("a", "b");

//        Function<String, Integer> function = s -> Integer.parseInt(s);
        Function<String, Integer> function = Integer::valueOf;
        System.out.println(function.apply("123"));
    }
}
