package com.chivalry.design.patterns.decorator;

/**
 * @author Mr.zxb
 * @date 2020-08-13 21:25:04
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        super.description = "Dark Roast";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
