package com.chivalry.design.patterns.iterator;

import java.util.ArrayList;

/**
 * 煎饼屋的菜单
 * @author Mr.zxb
 * @date 2020-08-30 21:15:37
 */
public class PancakeHouseMenu {
    /**
     * 这里使用ArrayList 实现
     */
    private final ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();

        addItem("煎饼早餐", "炒鸡蛋煎饼，加面包", true, 2.99);
        addItem("常规煎饼早餐", "煎饼配煎蛋，香肠", false, 2.99);
        addItem("蓝莓煎饼", "用新鲜蓝莓制成的煎饼", true, 3.49);
        addItem("华夫饼", "华夫饼，您可以选择蓝莓或草莓", true, 3.59);
    }

    /**
     * 新增菜单
     * @param name
     * @param description
     * @param vegetarian
     * @param price
     */
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    /**
     * 返回菜单列表
     * @return
     */
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public Iterator createIterator() {
        return new PancakeHouseIterator(getMenuItems());
    }
}
