package com.chivalry.design.patterns.decorator;

/**
 * @author Mr.zxb
 * @date 2020-08-13 21:39:22
 */
public class Venti extends CondimentDecorator {
    private final Beverage beverage;

    public Venti(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Venti";
    }

    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }
}
