package com.chivalry.design.patterns.command;

/**
 * 音响类
 * @author Mr.zxb
 * @date 2020-08-16 21:09:29
 */
public class Stereo {
    
    private String name;
    
    public Stereo(String name) {
        this.name = name;
    }

    public void on() {
        System.out.printf("%s stereo is on\n", name);
    }

    public void off() {
        System.out.printf("%s stereo is off\n", name);
    }

    public void setCD() {
        System.out.printf("%s stereo is et for CD input\n", name);
    }

    public void setVolume(int volume) {
        System.out.printf("%s stereo volume se to 11\n", name);
    }
}
