package com.chivalry.design.patterns.factory.abstractfactory.newyork;

import com.chivalry.design.patterns.factory.abstractfactory.PizzaIngredientFactory;
import com.chivalry.design.patterns.factory.abstractfactory.material.*;

/**
 * 纽约比萨配料厂
 * @author Mr.zxb
 * @date 2020-08-15 10:11:51
 */
public class NewYorkPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{ new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
    }

    @Override
    public Peppernoi createPepperoni() {
        return new SlicedPeppernoi();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
