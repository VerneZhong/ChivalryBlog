package com.chivalry.java.basic.java21.formatterswitch;

/**
 * switch 的模式匹配示例
 * @author Mr.Zxb
 * @description
 * @date 2025/03/06 20:58
 */
public class FormatterPatternSwitchDemo {
    public static void main(String[] args) {
        System.out.println(FormatterPatternSwitchDemo.format(1));
        System.out.println(FormatterPatternSwitchDemo.format(1L));
        System.out.println(FormatterPatternSwitchDemo.format(1.0));
        System.out.println(FormatterPatternSwitchDemo.format("hello"));
        System.out.println(FormatterPatternSwitchDemo.format(true));
        System.out.println(FormatterPatternSwitchDemo.format(new Object()));
    }

    public static String format(Object o) {
        return switch (o) {
            case Integer i -> String.format("Integer: %d", i);
            case Long l -> String.format("Long: %d", l);
            case Double d -> String.format("Double: %f", d);
            case String s -> String.format("String: %s", s);
            case Boolean b -> String.format("Boolean: %b", b);
            default -> String.format("Unknown: %s", o);
        };
    }
}

