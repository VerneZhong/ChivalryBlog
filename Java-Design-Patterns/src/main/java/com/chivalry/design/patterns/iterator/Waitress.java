package com.chivalry.design.patterns.iterator;

import java.util.ArrayList;

/**
 * @author Mr.zxb
 * @date 2020-08-30 21:31:44
 */
public class Waitress {

    private final PancakeHouseMenu pancakeHouseMenu;
    private final DinerMenu dinerMenu;

    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
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
