package com.chivalry.design.patterns.strategy;

/**
 * @author Mr.zxb
 * @date 2020-08-10 22:55:50
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        AbstractDuck duck = new MallardDuck();
        duck.performFly();
        duck.setQuackBehavior(new Squeak());
        duck.performQuack();
    }
}
