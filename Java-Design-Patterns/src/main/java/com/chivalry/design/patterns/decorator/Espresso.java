package com.chivalry.design.patterns.decorator;

/**
 * 浓咖啡
 * @author Mr.zxb
 * @date 2020-08-13 20:52:53
 */
public class Espresso extends Beverage {
    public Espresso() {
        // 浓咖啡描述
        super.description = "Espresso";
    }

    /**
     * 成本
     * @return
     */
    @Override
    public double cost() {
        return 1.99;
    }
}
