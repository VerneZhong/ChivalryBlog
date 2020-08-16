package com.chivalry.design.patterns.command;

/**
 * 打开电灯的命令
 * @author Mr.zxb
 * @date 2020-08-16 20:43:31
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
