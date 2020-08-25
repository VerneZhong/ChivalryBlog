package com.chivalry.design.patterns.template.method.transform;

import com.chivalry.design.patterns.template.method.CaffeineBeverage;

/**
 * 茶
 * @author Mr.zxb
 * @date 2020-08-25 21:41:18
 */
public class Tea extends CaffeineBeverage {

    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
