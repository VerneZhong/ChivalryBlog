package com.chivalry.design.patterns.strategy;

/**
 * @author Mr.zxb
 * @date 2020-08-10 22:43:40
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
