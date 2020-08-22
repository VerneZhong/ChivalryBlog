package com.chivalry.design.patterns.adapter;

/**
 * 野火鸡
 * @author Mr.zxb
 * @date 2020-08-21 22:06:44
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble.");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance.");
    }
}
