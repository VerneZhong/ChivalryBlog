package com.chivalry.design.patterns.strategy;

/**
 * 红头鸭
 * @author Mr.zxb
 * @date 2020-08-09 16:27:13
 */
public class RedheadDuck extends AbstractDuck implements Flyable, Quackable {
    @Override
    protected void display() {
        System.out.println("头是红色的.");
    }

    @Override
    public void quack() {
        System.out.println("嘎嘎叫...");
    }

    @Override
    public void fly() {
        System.out.println("飞行...");
    }
}
