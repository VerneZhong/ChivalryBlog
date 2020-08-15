package com.chivalry.design.patterns.factory.simplefactory;

/**
 * 比萨店
 * @author Mr.zxb
 * @date 2020-08-14 22:20:19
 */
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
