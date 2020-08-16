package com.chivalry.design.patterns.command;

/**
 * 遥控器简单测试
 * @author Mr.zxb
 * @date 2020-08-16 20:49:47
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        // 实例化一个简单遥控器装置
        SimpleRemoteControl remote = new SimpleRemoteControl();
        // 创建一个电灯
        Light light = new Light("Kitchen");
        // 创建一个命令
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        // 把命令传给调用者
        remote.setCommand(lightOnCommand);
        // 执行命令
        remote.buttonWasPressed();
    }
}
