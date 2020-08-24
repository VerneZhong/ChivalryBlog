package com.chivalry.design.patterns.facede;

/**
 * 投影仪
 * @author Mr.zxb
 * @date 2020-08-24 21:04:00
 */
public class Projector {
    private DvdPlayer dvdPlayer;

    public void on() {
        System.out.println("Projector on");
    }

    public void off() {
        System.out.println("Projector off");
    }

    public void tvMode() {
        System.out.println("Projector tvMode");
    }

    public void wideScreenMode() {
        System.out.println("Projector wideScreenMode");
    }

}
