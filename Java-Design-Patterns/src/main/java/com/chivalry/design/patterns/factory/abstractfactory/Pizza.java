package com.chivalry.design.patterns.factory.abstractfactory;

import com.chivalry.design.patterns.factory.abstractfactory.material.*;

import java.util.Arrays;

/**
 * 比萨抽象类
 * @author Mr.zxb
 * @date 2020-08-15 10:28:24
 */
public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Veggies[] veggies;
    protected Cheese cheese;
    protected Peppernoi peppernoi;
    protected Clams clams;

    abstract void prepare();

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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", veggies=" + Arrays.toString(veggies) +
                ", cheese=" + cheese +
                ", peppernoi=" + peppernoi +
                ", clams=" + clams +
                '}';
    }
}
