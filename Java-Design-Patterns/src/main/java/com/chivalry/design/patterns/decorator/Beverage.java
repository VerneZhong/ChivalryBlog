package com.chivalry.design.patterns.decorator;

/**
 * 饮料抽象类
 * @author Mr.zxb
 * @date 2020-08-13 20:48:22
 */
public abstract class Beverage {
    protected String description = "Unknown Beverage";

    /**
     * 获取饮料描述
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * 饮料成本抽象方法
     * @return
     */
    public abstract double cost();

}
