package com.chivalry.java.basic.paiza;

import java.util.ArrayList;
import java.util.List;

/**
 * @author verne.zhong
 */
public class NestedList<E> {
    private final List<E> elements;

    public NestedList() {
        elements = new ArrayList<>();
    }

    public void add(E e) {
        this.elements.add(e);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public List<E> flatten() {
        List<E> flatList = new ArrayList<>();
        flattenHelper(elements, flatList);
        return flatList;
    }

    private void flattenHelper(List<?> nestedList, List<E> flatList) {
        for (Object item : nestedList) {
            if (item instanceof List) {
                flattenHelper((List<?>) item, flatList);
            } else {
                flatList.add((E) item);
            }
        }
    }

    public static void main(String[] args) {
        NestedList<Object> nestedList = new NestedList<>();
        nestedList.add(List.of(1, 2, 3, 4, 5, 6, 7));
        nestedList.add(8);
        nestedList.add("abc");

        System.out.println(nestedList.isEmpty());
        System.out.println(nestedList.flatten());
    }
}
