package com.chivalry.design.patterns.command;

/**
 * 宏命令，一组命令
 * @author Mr.zxb
 * @date 2020-08-16 21:45:21
 */
public class MacroCommand implements Command {

    private final Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}
