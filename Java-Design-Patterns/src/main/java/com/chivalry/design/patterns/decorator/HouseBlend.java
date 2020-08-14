package com.chivalry.design.patterns.decorator;

/**
 * @author Mr.zxb
 * @date 2020-08-13 20:54:36
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        super.description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
