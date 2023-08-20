package com.chivalry.java.basic.java17;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * new feature in Java17 example
 *
 * @author verne.zhong
 * @description
 * @date 2023/08/20 13:03
 */
public class Feature {

    public static void main(String[] args) {
        Feature feature = new Feature();

        String json = feature.stringJson("Zxb", 31, "東京都中野区");
        System.out.println(json);

        System.out.println(feature.switchExpression(Fruit.APPLE));

        feature.testRecord();

        feature.instanceofTest(Fruit.APPLE);

//        feature.helpfulNPE(null);

        feature.testDateFormat();

        feature.testNumberFormat();

        feature.testStreamToList();
    }

    /**
     * text block
     *
     * @param name    　名前
     * @param age     　年齢
     * @param address 　アドレス
     * @return json
     */
    private String stringJson(String name, int age, String address) {
        return """
                {
                  "name": "%s",
                  "age": %s,
                  "address": "%s"
                }
                """.formatted(name, age, address);
    }

    /**
     * switch expression
     *
     * @param fruit
     * @return
     */
    public String switchExpression(Fruit fruit) {
        switch (fruit) {
            case APPLE, PEAR -> {
                return "普通水果";
            }
            case MANGO, AVOCADO -> {
                return "进口水果";
            }
            default -> {
                return "未知水果";
            }
        }
    }

    /**
     * 减少创建class样板代码，增加可读性和可维护性
     */
    public void testRecord() {
        Person p1 = new Person("小黑", 18, "东京都");
        Person p2 = new Person("小白", 28, "大阪府");

        record PersonRecord(String name, int age) {
        }

        PersonRecord pr1 = new PersonRecord(p1.getName(), p1.getAge());
        PersonRecord pr2 = new PersonRecord(p2.getName(), p2.getAge());

        System.out.println(pr1.name);
        System.out.println(pr2.age);
    }

    public void instanceofTest(Object o) {
        if (o instanceof Fruit fruit && "APPLE".equals(fruit.name())) {
            System.out.println(fruit.name());
        }
    }

    public void helpfulNPE(Fruit f) {
        System.out.println(f.name());
    }

    public void testDateFormat() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("B");
        System.out.println(dtf.format(LocalTime.of(8, 0)));
        System.out.println(dtf.format(LocalTime.of(13, 0)));
        System.out.println(dtf.format(LocalTime.of(20, 0)));
        System.out.println(dtf.format(LocalTime.of(23, 0)));
        System.out.println(dtf.format(LocalTime.of(0, 0)));
        System.out.println(dtf.format(LocalTime.now()));
    }

    public void testNumberFormat() {
        NumberFormat numberFormat = NumberFormat.getCompactNumberInstance(Locale.UK, NumberFormat.Style.SHORT);
        System.out.println(numberFormat.format(10000));
        System.out.println(numberFormat.format(1000000));
        System.out.println(numberFormat.format(1000000000));
    }

    public void testStreamToList() {
        Stream.of(1, 2, 3, 4, 5, 6).toList().forEach(System.out::println);
    }
}
