package com.chivalry.design.patterns.decorator;

/**
 * 摩卡咖啡
 * @author Mr.zxb
 * @date 2020-08-13 20:56:58
 */
public class Mocha extends CondimentDecorator {

    /**
     * 1) 用一个实例变量记录饮料，也就是被装饰者。
     * 2) 想办法让装饰者（饮料）被记录到实例变量中。
     */
    private final Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        // 获取完整的调料描述
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        // 首先把调用委托给被装饰对象，以计算价格，然后加上 Mocha的价格，得到最后的结果
        return 0.20 + beverage.cost();
    }
}
