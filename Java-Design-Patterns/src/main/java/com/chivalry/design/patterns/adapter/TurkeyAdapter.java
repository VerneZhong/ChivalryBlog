package com.chivalry.design.patterns.adapter;

/**
 * 火鸡适配器，将火鸡伪装成鸭子类
 * @author Mr.zxb
 * @date 2020-08-21 22:07:25
 */
public class TurkeyAdapter implements Duck {

    private final Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
