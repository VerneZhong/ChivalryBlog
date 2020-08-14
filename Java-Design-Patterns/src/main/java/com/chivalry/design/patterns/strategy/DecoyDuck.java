package com.chivalry.design.patterns.strategy;

/**
 * 诱饵鸭，既不会飞，也不会叫
 * @author Mr.zxb
 * @date 2020-08-10 22:24:54
 */
public class DecoyDuck extends AbstractDuck {
    @Override
    protected void display() {
        System.out.println("诱饵鸭五颜六色");
    }
}
