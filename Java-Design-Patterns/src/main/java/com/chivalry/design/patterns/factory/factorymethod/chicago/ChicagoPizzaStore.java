package com.chivalry.design.patterns.factory.factorymethod.chicago;

import com.chivalry.design.patterns.factory.simplefactory.Pizza;
import com.chivalry.design.patterns.factory.simplefactory.PizzaStore;

/**
 * 芝加哥风味的比萨店
 * @author Mr.zxb
 * @date 2020-08-14 22:18:48
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        // 根据不同的类型，创建不同的实例对象
        if ("cheese".equals(type)) {
            pizza = new ChicagoStyleCheesePizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new ChicagoStyleClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new ChicagoStyleVeggiePizza();
        }
        return pizza;
    }
}
