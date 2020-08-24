package com.chivalry.design.patterns.facede;

/**
 * DVD播放机
 * @author Mr.zxb
 * @date 2020-08-24 21:02:58
 */
public class DvdPlayer {
    private Amplifier amplifier;
    public void on() {
        System.out.println("DvdPlayer on");
    }
    public void off() {
        System.out.println("DvdPlayer off");
    }

    public void eject() {
        System.out.println("DvdPlayer eject");
    }

    public void pause() {
        System.out.println("DvdPlayer pause");
    }

    public void play(String movie) {
        System.out.println("DvdPlayer play " + movie);
    }

    public void setSurroundAudio() {
        System.out.println("DvdPlayer setSurroundAudio");
    }

    public void setTwoChannelAudio() {
        System.out.println("DvdPlayer setTwoChannelAudio");
    }

    public void stop() {
        System.out.println("DvdPlayer stop");
    }
}
