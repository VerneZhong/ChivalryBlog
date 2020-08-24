package com.chivalry.design.patterns.facede;

/**
 * @author Mr.zxb
 * @date 2020-08-24 21:17:49
 */
public class HomeTheaterTestDrive {
    public static void main(String[] args) {

        // 实例化各组件
        Amplifier amplifier = new Amplifier();
        Tuner tuner = new Tuner();
        DvdPlayer dvdPlayer = new DvdPlayer();
        CdPlayer cdPlayer = new CdPlayer();
        Projector projector = new Projector();
        TheaterLights theaterLights = new TheaterLights();
        Screen screen = new Screen();
        PopcornPopper popcornPopper = new PopcornPopper();

        // 根据子系统所有的组件来实例化外观
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amplifier, tuner, dvdPlayer, cdPlayer, projector, theaterLights, screen, popcornPopper);

        // 使用简化接口来开启电影
        homeTheaterFacade.watchMovie("Raiders of the Lost Ark");
        // 然后关闭电影
        homeTheaterFacade.endMovie();
    }
}
