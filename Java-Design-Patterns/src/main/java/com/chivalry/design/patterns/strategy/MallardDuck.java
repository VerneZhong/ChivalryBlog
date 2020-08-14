package com.chivalry.design.patterns.strategy;

/**
 * 绿头鸭
 * @author Mr.zxb
 * @date 2020-08-09 16:26:10
 */
public class MallardDuck extends AbstractDuck {

    public MallardDuck() {
        quackBehavior = new Quack();

        flyBehavior = new FlyWithWings();
    }

    @Override
    protected void display() {
        System.out.println("头是绿色的.");
    }

}
