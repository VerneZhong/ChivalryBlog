package com.chivalry.design.patterns.factory.abstractfactory.chicago;

import com.chivalry.design.patterns.factory.abstractfactory.PizzaIngredientFactory;
import com.chivalry.design.patterns.factory.abstractfactory.material.*;
import com.chivalry.design.patterns.factory.abstractfactory.newyork.*;

/**
 * 芝加哥比萨配料厂
 * @author Mr.zxb
 * @date 2020-08-15 10:11:51
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new Mozzarella();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{ new BlackOlives(), new EggPlant(), new Spinach() };
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
