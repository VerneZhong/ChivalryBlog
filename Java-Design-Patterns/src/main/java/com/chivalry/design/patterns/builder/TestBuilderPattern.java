package com.chivalry.design.patterns.builder;

/**
 * 测试程序
 * @author Mr.zxb
 * @date 2020-09-19 21:08:39
 */
public class TestBuilderPattern {
    public static void main(String[] args) {
        // Using builder to get the object in a single line of code and
        // without any inconsistent state or arguments management issues
        Computer computer = new Computer.ComputerBuilder("500GB", "8GB")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true)
                .build();

        System.out.println(computer);
    }
}
