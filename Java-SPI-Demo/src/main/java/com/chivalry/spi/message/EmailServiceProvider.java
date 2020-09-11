package com.chivalry.spi.message;

/**
 * 邮件服务提供者
 * @author Mr.zxb
 * @date 2020-09-11 23:47:38
 */
public class EmailServiceProvider implements MessageServiceProvider {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Email with Message = " + message);
    }
}
