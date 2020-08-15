package com.chivalry.design.patterns.factory.abstractfactory.test;

import com.chivalry.design.patterns.factory.abstractfactory.NewYorkPizzaStore;
import com.chivalry.design.patterns.factory.abstractfactory.Pizza;
import com.chivalry.design.patterns.factory.abstractfactory.PizzaStore;

/**
 * @author Mr.zxb
 * @date 2020-08-15 10:41:45
 */
public class PizzaStoreTest {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NewYorkPizzaStore();
        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println(pizza);
    }
}
