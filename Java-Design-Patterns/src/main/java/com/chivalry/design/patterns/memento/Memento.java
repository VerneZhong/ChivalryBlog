package com.chivalry.design.patterns.memento;

/**
 * 备忘录：存储状态
 *
 * @author Mr.Zxb
 * @description
 * @date 2025/03/01 19:46
 */
public class Memento {
    /**
     * 状态
     */
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
