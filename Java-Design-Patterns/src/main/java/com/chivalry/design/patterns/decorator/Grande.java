package com.chivalry.design.patterns.decorator;

/**
 * @author Mr.zxb
 * @date 2020-08-13 21:38:23
 */
public class Grande extends CondimentDecorator {
    private final Beverage beverage;

    public Grande(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Grande";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }
}
