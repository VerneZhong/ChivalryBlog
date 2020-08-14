package com.chivalry.design.patterns.decorator;

/**
 * 小杯
 * @author Mr.zxb
 * @date 2020-08-13 21:37:13
 */
public class Tall extends CondimentDecorator {

    private final Beverage beverage;

    public Tall(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", tall";
    }

    @Override
    public double cost() {
        return 0.1 + beverage.cost();
    }
}
