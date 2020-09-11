package com.chivalry.spi.message;

/**
 * 消息服务提供者接口
 * @author Mr.zxb
 * @date 2020-09-11 23:46:59
 */
public interface MessageServiceProvider {
    /**
     * 发送消息
     * @param message
     */
    void sendMessage(String message);
}
