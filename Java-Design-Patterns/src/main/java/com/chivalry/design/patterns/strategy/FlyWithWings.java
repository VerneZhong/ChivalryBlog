package com.chivalry.design.patterns.strategy;

/**
 * @author Mr.zxb
 * @date 2020-08-10 22:39:06
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("鸭子飞...");
    }
}
