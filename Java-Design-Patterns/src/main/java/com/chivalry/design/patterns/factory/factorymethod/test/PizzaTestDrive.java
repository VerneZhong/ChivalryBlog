package com.chivalry.design.patterns.factory.factorymethod.test;

import com.chivalry.design.patterns.factory.simplefactory.Pizza;
import com.chivalry.design.patterns.factory.simplefactory.PizzaStore;
import com.chivalry.design.patterns.factory.factorymethod.chicago.ChicagoPizzaStore;
import com.chivalry.design.patterns.factory.factorymethod.ny.NewYorkPizzaStore;

/**
 * 测试
 * @author Mr.zxb
 * @date 2020-08-14 23:09:59
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        // 创建纽约风味的比萨店
        PizzaStore nyStore = new NewYorkPizzaStore();
        // 创建芝加哥风味的比萨店
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
