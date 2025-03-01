package com.chivalry.design.patterns.memento;

/**
 * 测试类
 * @author Mr.Zxb
 * @description
 * @date 2025/03/01 19:54
 */
public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("状态1");
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState("状态2");
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState("状态3");
        caretaker.addMemento(originator.saveStateToMemento());
        System.out.println("当前状态：" + originator);

        // 恢复到之前的状态
        // 恢复到状态1
        originator.restoreFromMemento(caretaker.getMemento(0));
    }
}
