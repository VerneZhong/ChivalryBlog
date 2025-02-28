package com.chivalry.design.patterns.mediator;

/**
 * 具体飞机 B
 * @author Mr.Zxb
 * @description
 * @date 2025/02/28 21:59
 */
public class AirbusA320 extends Airplane {
    public AirbusA320(AirTrafficControl controlTower) {
        super(controlTower);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("AirbusA320 发送消息：" + message);
        controlTower.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("AirbusA320 收到消息：" + message);
    }
}
