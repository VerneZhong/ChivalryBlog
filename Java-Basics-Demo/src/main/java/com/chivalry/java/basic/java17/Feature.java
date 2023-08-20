package com.chivalry.java.basic.java17;

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
    }

    private String stringJson(String name, int age, String address) {
        return  """
            {
              "name": "%s",
              "age": %s,
              "address": "%s"
            }
            """.formatted(name, age, address);
    }
}
