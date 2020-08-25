package com.chivalry.design.patterns.template.method.transform;

import com.chivalry.design.patterns.template.method.CaffeineBeverage;

/**
 * 咖啡
 * @author Mr.zxb
 * @date 2020-08-25 21:38:09
 */
public class Coffee extends CaffeineBeverage {

    @Override
    protected void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

}
