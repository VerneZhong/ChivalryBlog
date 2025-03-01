package com.chivalry.design.patterns.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理者：存储多个备忘录
 * @author Mr.Zxb
 * @description
 * @date 2025/03/01 19:53
 */
public class Caretaker {
    private final List<Memento> history = new ArrayList<>();

    public void addMemento(Memento memento) {
        history.add(memento);
    }

    public Memento getMemento(int index) {
        return history.get(index);
    }
}
