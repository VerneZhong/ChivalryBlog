package com.chivalry.design.patterns.strategy;

/**
 * 鸭子超类
 *
 * @author Mr.zxb
 * @date 2020-08-09 16:22:48
 */
public abstract class AbstractDuck {

    /**
     * 飞行行为
     */
    protected FlyBehavior flyBehavior;

    /**
     * 叫声行为
     */
    protected QuackBehavior quackBehavior;

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    /**
     * 游泳
     */
    protected void swim() {
        System.out.println("游泳...");
    }

    /**
     * 由于每种鸭子外观不同，提供抽象方法
     */
    protected abstract void display();

    // other method...
}
