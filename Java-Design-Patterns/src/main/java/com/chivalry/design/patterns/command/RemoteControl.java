package com.chivalry.design.patterns.command;

/**
 * 遥控器
 * @author Mr.zxb
 * @date 2020-08-16 20:59:49
 */
public class RemoteControl {
    /**
     * 一组打开命令
     */
    private final Command[] onCommands;
    /**
     * 一组关闭命令
     */
    private final Command[] offCommands;
    /**
     * 撤销命令
     */
    private Command undoCommand;

    public RemoteControl() {
        this.onCommands = new Command[7];
        this.offCommands = new Command[7];

        // 预先设置无命令的Command
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            this.onCommands[i] = noCommand;
            this.offCommands[i] = noCommand;
        }
        this.undoCommand = noCommand;
    }

    /**
     * 指定插槽设置开和关命令
     * @param slot
     * @param onCommand
     * @param offCommand
     */
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommands[slot] = onCommand;
        this.offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        this.onCommands[slot].execute();
        this.undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        this.offCommands[slot].execute();
        this.undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        this.undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n------- Remote Control-------\n");
        for (int i = 0; i < this.onCommands.length; i++) {
            buffer.append("[slot ")
                    .append(i)
                    .append(" ]")
                    .append(this.onCommands[i].getClass().getName())
                    .append("    ")
                    .append(this.offCommands[i].getClass().getName())
                    .append("\n");
        }
        return buffer.toString();
    }
}
