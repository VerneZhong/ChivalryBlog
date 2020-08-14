package com.chivalry.design.patterns.strategy;

/**
 * @author Mr.zxb
 * @date 2020-08-10 22:44:20
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        // 什么都不做，不会叫
    }
}
