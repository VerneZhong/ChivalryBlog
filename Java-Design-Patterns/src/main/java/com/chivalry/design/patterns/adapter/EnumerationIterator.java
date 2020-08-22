package com.chivalry.design.patterns.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 枚举迭代器适配器
 * @author Mr.zxb
 * @date 2020-08-21 22:43:49
 */
public class EnumerationIterator<T> implements Iterator<T> {

    private final Enumeration<T> enumeration;

    public EnumerationIterator(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }
}
