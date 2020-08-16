package com.chivalry.design.patterns.command;

/**
 * 电灯类
 * @author Mr.zxb
 * @date 2020-08-16 20:44:01
 */
public class Light {

    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.printf("%s Light is on\n", name);
    }

    public void off() {
        System.out.printf("%s Light is off\n", name);
    }
}
