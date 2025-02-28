package com.chivalry.design.patterns.mediator;

/**
 * 飞机抽象类
 *
 * @author Mr.Zxb
 * @description
 * @date 2025/02/28 21:47
 */
public abstract class Airplane {

    protected AirTrafficControl controlTower;

    public Airplane(AirTrafficControl controlTower) {
        this.controlTower = controlTower;
    }

    public abstract void sendMessage(String message);
    public abstract void receiveMessage(String message);
}
