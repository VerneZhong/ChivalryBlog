package com.chivalry.design.patterns.decorator;

/**
 * @author Mr.zxb
 * @date 2020-08-13 21:28:33
 */
public class Soy extends CondimentDecorator {

    private final Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return 0.8 + beverage.cost();
    }
}
