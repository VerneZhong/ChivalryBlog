package com.chivalry.design.patterns.command;

/**
 * 关闭电灯的命令
 * @author Mr.zxb
 * @date 2020-08-16 20:43:31
 */
public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
