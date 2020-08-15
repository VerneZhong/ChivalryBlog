package com.chivalry.design.patterns.factory.factorymethod.chicago;

import com.chivalry.design.patterns.factory.simplefactory.Pizza;

/**
 * @author Mr.zxb
 * @date 2020-08-14 22:35:47
 */
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        super.name = "Chicago Style Deep Dish Cheese Pizza";
        super.dough = "Extra Thick Crust Dough";
        super.sauce = "Plum Tomato Sauce";
        super.toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
