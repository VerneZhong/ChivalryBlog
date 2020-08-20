package com.chivalry.design.patterns.command;

/**
 * 简单的遥控器
 * @author Mr.zxb
 * @date 2020-08-16 20:47:25
 */
public class SimpleRemoteControl {
    /**
     * 一个插槽
     */
    private Command slot;

    /**
     * 设置插槽控制的命令
     * @param command
     */
    public void setCommand(Command command) {
        slot = command;
    }

    /**
     * 按下按钮的功能
     */
    public void buttonWasPressed() {
        slot.execute();
    }
}
