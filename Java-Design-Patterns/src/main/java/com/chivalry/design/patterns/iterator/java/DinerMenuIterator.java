package com.chivalry.design.patterns.iterator.java;

import com.chivalry.design.patterns.iterator.MenuItem;

import java.util.Iterator;

/**
 * @author Mr.zxb
 * @date 2020-08-30 21:46:17
 */
public class DinerMenuIterator implements Iterator {

    private final MenuItem[] items;
    // 记录当前数组遍历的位置
    int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        MenuItem item = items[position];
        position++;
        return item;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove an item until you've done at least one next()");
        }
        if (items[position - 1] != null) {
            for (int i = position - 1; i < (items.length - 1); i++) {
                items[i] = items[i + 1];
            }
            items[items.length - 1] = null;
        }
    }
}
