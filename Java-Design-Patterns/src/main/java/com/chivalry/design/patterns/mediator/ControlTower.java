package com.chivalry.design.patterns.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的中介者（塔台）
 * @author Mr.Zxb
 * @description
 * @date 2025/02/28 21:53
 */
public class ControlTower implements AirTrafficControl {

    private final List<Airplane> airplanes = new ArrayList<>();

    /**
     * 注册飞机
     * @param airplane
     */
    public void registerAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    /**
     * 通过中介者发送消息
     * @param message
     * @param sender
     */
    @Override
    public void sendMessage(String message, Airplane sender) {
        airplanes.forEach(airplane -> {
            if (airplane != sender) {
                airplane.receiveMessage(message);
            }
        });
    }
}
