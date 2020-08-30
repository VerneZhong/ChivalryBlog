package com.chivalry.design.patterns.iterator.java;

import com.chivalry.design.patterns.iterator.MenuItem;

import java.util.Iterator;

/**
 * @author Mr.zxb
 * @date 2020-08-30 21:31:44
 */
public class Waitress {

    private final Menu pancakeHouseMenu;
    private final Menu dinerMenu;

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        Iterator iterator = pancakeHouseMenu.createIterator();
        printMenu(iterator);
        Iterator dinerMenuIterator = dinerMenu.createIterator();
        printMenu(dinerMenuIterator);
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + " ");
            System.out.println(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription());
        }
    }
}
