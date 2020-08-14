package com.chivalry.design.patterns.strategy;

/**
 * @author Mr.zxb
 * @date 2020-08-10 22:58:11
 */
public class ModelDuck extends AbstractDuck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    protected void display() {
        System.out.println("I'm a model duck.");
    }
}
