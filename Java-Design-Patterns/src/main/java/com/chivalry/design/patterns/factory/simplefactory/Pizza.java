package com.chivalry.design.patterns.factory.simplefactory;

import java.util.ArrayList;

/**
 * 普通比萨
 * @author Mr.zxb
 * @date 2020-08-14 21:39:59
 */
public class Pizza {

    protected String name;
    protected String dough;
    protected String sauce;
    protected ArrayList<String> toppings = new ArrayList<>();

    /**
     * 打包比萨
     */
    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    /**
     * 切比萨
     */
    public void cut() {
        System.out.println("Cut the pizza into diagonal slices");
    }

    /**
     * 烘烤比萨
     */
    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    /**
     * 准备比萨
     */
    public void prepare() {
        System.out.println("Prepare " + name +" Pizza");
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println("   " + toppings.get(i));
        }
    }

    public String getName() {
        return name;
    }
}
