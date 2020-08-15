package com.chivalry.design.patterns.factory.abstractfactory;

import com.chivalry.design.patterns.factory.abstractfactory.newyork.NewYorkPizzaIngredientFactory;

/**
 * 纽约比萨店
 * @author Mr.zxb
 * @date 2020-08-15 10:33:49
 */
public class NewYorkPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        PizzaIngredientFactory ingredientFactory = new NewYorkPizzaIngredientFactory();
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        }
        // ...
        return pizza;
    }
}
