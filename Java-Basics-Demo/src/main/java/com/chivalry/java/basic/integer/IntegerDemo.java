package com.chivalry.java.basic.integer;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-09-18 15:48
 */
public class IntegerDemo {
    public static void main(String[] args) {
        Integer i1 = 3;
        Integer i2 = new Integer(3);
        Integer i3 = i1;
        Integer i4 = 3;
        // Integer cache range [-128, 127]
        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i1==i2);
        System.out.println(i1==i3);
        System.out.println(i1==i4);
        System.out.println(i5==i6);
    }
}
