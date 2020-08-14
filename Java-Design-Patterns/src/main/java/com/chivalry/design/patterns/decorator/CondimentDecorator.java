package com.chivalry.design.patterns.decorator;

/**
 * 调味品装饰器
 * @author Mr.zxb
 * @date 2020-08-13 20:50:47
 */
public abstract class CondimentDecorator extends Beverage {

    /**
     * 获取饮料描述
     * @return
     */
    @Override
    public abstract String getDescription();

}
