package com.chivalry.design.patterns.factory.abstractfactory;

import com.chivalry.design.patterns.factory.abstractfactory.material.*;

/**
 * 建造原料工厂
 * @author Mr.zxb
 * @date 2020-08-15 10:05:27
 */
public interface PizzaIngredientFactory {
    /**
     * 创建面团
     * @return
     */
    Dough createDough();

    /**
     * 创建酱汁
     * @return
     */
    Sauce createSauce();

    /**
     * 创建奶酪
     * @return
     */
    Cheese createCheese();

    /**
     *创建蔬菜
     * @return
     */
    Veggies[] createVeggies();

    /**
     *创建意大利辣香肠
     * @return
     */
    Peppernoi createPepperoni();

    /**
     * 创建蛤蜊
     * @return
     */
    Clams createClam();
}
