package com.chivalry.design.patterns.iterator;

/**
 * 菜单项
 * @author Mr.zxb
 * @date 2020-08-30 21:13:06
 */
public class MenuItem {
    // 菜名
    String name;
    // 描述
    String description;
    // 是否素食
    boolean vegetarian;
    // 价格
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
