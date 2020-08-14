package com.chivalry.design.patterns.strategy;

/**
 * 橡皮鸭
 * @author Mr.zxb
 * @date 2020-08-10 22:26:05
 */
public class RubberDuck extends AbstractDuck implements Quackable {
    @Override
    protected void display() {
        System.out.println("橡皮鸭");
    }

    @Override
    public void quack() {
        System.out.println("橡皮鸭吱吱叫...");
    }
}
