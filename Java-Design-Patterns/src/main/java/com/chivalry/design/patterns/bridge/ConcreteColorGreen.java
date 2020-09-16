package com.chivalry.design.patterns.bridge;

/**
 * @author Mr.zxb
 * @date 2020-09-16 21:46:00
 */
public class ConcreteColorGreen implements ColorImplementor {
    @Override
    public void applyColor() {
        System.out.println("Apply Green...");
    }
}
