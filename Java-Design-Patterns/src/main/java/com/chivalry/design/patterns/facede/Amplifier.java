package com.chivalry.design.patterns.facede;

/**
 * 功放
 * @author Mr.zxb
 * @date 2020-08-24 20:59:55
 */
public class Amplifier {
    private Tuner tuner;
    private DvdPlayer dvdPlayer;
    private CdPlayer cdPlayer;

    public void on() {
        System.out.println("Amplifier on");
    }

    public void off() {
        System.out.println("Amplifier off");
    }

    public void setCd() {
        System.out.println("Amplifier setCd");
    }

    public void setDvd(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

    public void setStereoSound() {
        System.out.println("Amplifier setStereoSound");
    }

    public void setSurroundSound() {
        System.out.println("Amplifier setSurroundSound");
    }

    public void setTuner() {
        System.out.println("Amplifier setTuner");
    }

    public void setVolume(int i) {
        System.out.println("Amplifier setVolume " + i);
    }
}
