package com.chivalry.design.patterns.factory.factorymethod.ny;

import com.chivalry.design.patterns.factory.simplefactory.Pizza;

/**
 * @author Mr.zxb
 * @date 2020-08-14 22:35:47
 */
public class NewYorkStyleCheesePizza extends Pizza {
    public NewYorkStyleCheesePizza() {
        super.name = "New York Style Sauce and Cheese Pizza";
        super.dough = "Thin Crust Dough";
        super.sauce = "Marinara Sauce";
        super.toppings.add("Grated Reggiano Cheese");
    }
}
