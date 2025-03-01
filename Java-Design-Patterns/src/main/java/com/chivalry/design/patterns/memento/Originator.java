package com.chivalry.design.patterns.memento;

/**
 * 发起人：创建和恢复备忘录
 * @author Mr.Zxb
 * @description
 * @date 2025/03/01 19:48
 */
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
        System.out.println("当前状态： " + state);
    }

    /**
     * 保存状态
     * @return
     */
    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    /**
     * 恢复备忘录
     * @param memento
     */
    public void restoreFromMemento(Memento memento) {
        this.state = memento.getState();
        System.out.println("状态恢复为：" + state);
    }

    @Override
    public String toString() {
        return "Originator{" +
                "state='" + state + '\'' +
                '}';
    }
}
