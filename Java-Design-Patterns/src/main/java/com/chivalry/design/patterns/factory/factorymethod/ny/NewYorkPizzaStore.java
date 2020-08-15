package com.chivalry.design.patterns.factory.factorymethod.ny;

import com.chivalry.design.patterns.factory.simplefactory.Pizza;
import com.chivalry.design.patterns.factory.simplefactory.PizzaStore;

/**
 * 纽约风味的比萨店
 * @author Mr.zxb
 * @date 2020-08-14 22:18:48
 */
public class NewYorkPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        // 根据不同的类型，创建不同的实例对象
        if ("cheese".equals(type)) {
            pizza = new NewYorkStyleCheesePizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new NewYorkStylePepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new NewYorkStyleClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new NewYorkStyleVeggiePizza();
        }
        return pizza;
    }
}
