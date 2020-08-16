package com.chivalry.design.patterns.command;

/**
 * 音响命令对象
 * @author Mr.zxb
 * @date 2020-08-16 21:09:13
 */
public class StereoOffWithCDCommand implements Command {

    private Stereo stereo;

    public StereoOffWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
    }
}
