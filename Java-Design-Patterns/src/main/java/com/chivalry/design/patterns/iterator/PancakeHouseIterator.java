package com.chivalry.design.patterns.iterator;

import java.util.ArrayList;

/**
 * @author Mr.zxb
 * @date 2020-08-30 22:12:26
 */
public class PancakeHouseIterator implements Iterator {

    private final ArrayList<MenuItem> menuItems;
    int position = 0;

    public PancakeHouseIterator(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.size() || menuItems.get(position) == null) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        MenuItem menuItem = menuItems.get(position);
        position++;
        return menuItem;
    }
}
