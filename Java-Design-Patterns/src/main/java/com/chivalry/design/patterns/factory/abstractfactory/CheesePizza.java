package com.chivalry.design.patterns.factory.abstractfactory;

/**
 * 芝士披萨
 * @author Mr.zxb
 * @date 2020-08-15 10:31:14
 */
public class CheesePizza extends Pizza {

    private final PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        super.dough = ingredientFactory.createDough();
        super.sauce = ingredientFactory.createSauce();
        super.cheese = ingredientFactory.createCheese();
        super.veggies = ingredientFactory.createVeggies();
        super.clams = ingredientFactory.createClam();
        super.peppernoi = ingredientFactory.createPepperoni();
    }
}
