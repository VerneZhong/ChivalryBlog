package com.chivalry.design.patterns.decorator;

/**
 * @author Mr.zxb
 * @date 2020-08-13 21:29:27
 */
public class Milk extends CondimentDecorator {

    private final Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return 0.4 + beverage.cost();
    }
}
