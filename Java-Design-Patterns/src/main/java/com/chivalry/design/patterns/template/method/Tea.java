package com.chivalry.design.patterns.template.method;

/**
 * 茶
 * @author Mr.zxb
 * @date 2020-08-25 21:41:18
 */
public class Tea {
    /**
     * 制作茶
     */
    void prepareRecipe() {
        // 烧水
        boilWater();
        // 冲泡茶包
        steepTeaBag();
        // 倒入杯子
        pourInCup();
        // 加柠檬
        addLemon();
    }

    private void addLemon() {
        System.out.println("Adding Lemon");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    private void steepTeaBag() {
        System.out.println("Steeping the tea");
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }
}
