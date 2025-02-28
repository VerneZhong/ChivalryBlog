package com.chivalry.design.patterns.mediator;

/**
 * 中介者接口，定义通信规则
 *
 * @author Mr.Zxb
 * @description
 * @date 2025/02/28 21:47
 */
public interface AirTrafficControl {
    void sendMessage(String message, Airplane airplane);
}
