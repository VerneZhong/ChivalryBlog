package com.chivalry.design.patterns.decorator;

/**
 * @author Mr.zxb
 * @date 2020-08-13 21:26:54
 */
public class Whip extends CondimentDecorator {

    private final Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.5 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() +", Whip";
    }
}
