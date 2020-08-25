package com.chivalry.design.patterns.template.method;

/**
 * 咖啡
 * @author Mr.zxb
 * @date 2020-08-25 21:38:09
 */
public class Coffee {
    /**
     * 制作咖啡
     */
    void prepareRecipe() {
        // 烧水
        boilWater();
        // 冲泡咖啡粉
        brewCoffeeGrinds();
        // 倒入杯子
        pourInCup();
        // 加糖和牛奶
        addSugarAndMilk();
    }

    private void addSugarAndMilk() {
        System.out.println("Adding Sugar and Milk");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    private void brewCoffeeGrinds() {
        System.out.println("Dripping Coffee through filter");
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }
}
