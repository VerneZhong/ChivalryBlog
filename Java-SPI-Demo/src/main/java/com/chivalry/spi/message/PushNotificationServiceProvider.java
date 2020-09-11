package com.chivalry.spi.message;

/**
 * 推送通知服务提供者实现
 * @author Mr.zxb
 * @date 2020-09-11 23:48:12
 */
public class PushNotificationServiceProvider implements MessageServiceProvider {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Push Notification with Message = " + message);
    }
}
