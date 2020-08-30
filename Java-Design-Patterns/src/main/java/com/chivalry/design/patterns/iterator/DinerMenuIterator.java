package com.chivalry.design.patterns.iterator;

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
}
