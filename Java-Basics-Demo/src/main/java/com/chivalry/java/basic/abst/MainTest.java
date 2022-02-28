package com.chivalry.java.basic.abst;

public class MainTest {

    public static void main(String[] args) {
        AbstractTest abstractTest = new AbstractTest()
        {
            @Override
            public void init() {
                System.out.println("init.");
            }
        };

        abstractTest.init();
        abstractTest.test();

        AbstractTest child = new AbstractTestChild();
        child.init();
        child.test();
    }
}
