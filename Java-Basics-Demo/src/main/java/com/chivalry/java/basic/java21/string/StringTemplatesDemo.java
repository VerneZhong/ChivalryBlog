package com.chivalry.java.basic.java21.string;

import java.text.MessageFormat;

import static java.lang.StringTemplate.STR;

/**
 * 字符串模板
 * @author Mr.Zxb
 * @description
 * @date 2025/03/06 20:58
 */
public class StringTemplatesDemo {

    public static void main(String[] args) {
        String name = "Verne Zhong";
        // concatenation
        String message = "Greetings " + name + "!";
        System.out.println(message);

        // String.format()
        message = String.format("Greetings %s!", name);
        System.out.println(message);

        // MessageFormat
        message = MessageFormat.format("Greetings {0}!", name);
        System.out.println(message);

        // StringBuild
        message = new StringBuilder("Greetings ").append(name).append("!").toString();
        System.out.println(message);

        // Java 使用 String Templates 进行字符串拼接，可以直接在字符串中嵌入表达式
        message = STR."Greetings \{name}!";
        System.out.println(message);
    }
}
