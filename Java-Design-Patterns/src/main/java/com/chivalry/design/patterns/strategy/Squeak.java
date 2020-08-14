package com.chivalry.design.patterns.strategy;

/**
 * @author Mr.zxb
 * @date 2020-08-10 22:44:02
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}
