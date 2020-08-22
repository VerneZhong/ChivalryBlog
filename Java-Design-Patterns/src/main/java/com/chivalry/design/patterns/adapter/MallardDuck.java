package com.chivalry.design.patterns.adapter;

/**
 * 鸭子实现
 * @author Mr.zxb
 * @date 2020-08-21 22:05:32
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying.");
    }
}
