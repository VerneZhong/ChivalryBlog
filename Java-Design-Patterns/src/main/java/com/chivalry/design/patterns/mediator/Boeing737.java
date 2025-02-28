package com.chivalry.design.patterns.mediator;

/**
 * 具体飞机A
 * @author Mr.Zxb
 * @description
 * @date 2025/02/28 21:57
 */
public class Boeing737 extends Airplane {
    public Boeing737(AirTrafficControl controlTower) {
        super(controlTower);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Boeing737 发送消息：" + message);
        controlTower.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Boeing737 收到消息：" + message);
    }
}
