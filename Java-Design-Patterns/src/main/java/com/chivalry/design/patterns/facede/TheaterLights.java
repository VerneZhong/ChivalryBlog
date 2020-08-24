package com.chivalry.design.patterns.facede;

/**
 * 剧院灯
 * @author Mr.zxb
 * @date 2020-08-24 21:06:14
 */
public class TheaterLights {
    public void on() {
        System.out.println("TheaterLights on");
    }

    public void off() {
        System.out.println("TheaterLights off");
    }

    public void dim(int i) {
        System.out.println("TheaterLights dim " + i);
    }
}
