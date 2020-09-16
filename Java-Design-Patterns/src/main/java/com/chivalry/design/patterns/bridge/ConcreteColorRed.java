package com.chivalry.design.patterns.bridge;

/**
 * @author Mr.zxb
 * @date 2020-09-16 21:42:33
 */
public class ConcreteColorRed implements ColorImplementor {
    @Override
    public void applyColor() {
        System.out.println("Applying Red....");
    }
}
