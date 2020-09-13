package com.chivalry.java.basic.question;

/**
 * {@link String#intern()} 示例
 * @author Mr.zxb
 * @date 2020-09-13 11:02:52
 */
public class StringInternDemo {
    public static void main(String[] args) {
        // s1 ->  Constant Pool -> abc
        String s1 = "abc";
        // s2 -> Java Heap String -> Constant Pool
        String s2 = new String("abc");

        //
        s2.intern();
//        s2 = s2.intern();

        // 输出结果 -> true false
        System.out.println(s1 == s2);
    }
}
