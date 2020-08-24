package com.chivalry.design.patterns.facede;

/**
 * 家庭影院
 * @author Mr.zxb
 * @date 2020-08-24 21:09:03
 */
public class HomeTheaterFacade {

    private final Amplifier amplifier;
    private final Tuner tuner;
    private final DvdPlayer dvdPlayer;
    private final CdPlayer cdPlayer;
    private final Projector projector;
    private final TheaterLights theaterLights;
    private final Screen screen;
    private final PopcornPopper popcornPopper;

    public HomeTheaterFacade(Amplifier amplifier, Tuner tuner, DvdPlayer dvdPlayer,
                             CdPlayer cdPlayer, Projector projector,
                             TheaterLights theaterLights, Screen screen,
                             PopcornPopper popcornPopper) {
        this.amplifier = amplifier;
        this.tuner = tuner;
        this.dvdPlayer = dvdPlayer;
        this.cdPlayer = cdPlayer;
        this.projector = projector;
        this.theaterLights = theaterLights;
        this.screen = screen;
        this.popcornPopper = popcornPopper;
    }

    public void watchMovie(String movie) {
        System.out.println("Get Ready to watch a movie....");
        popcornPopper.on();
        popcornPopper.pop();
        theaterLights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setDvd(dvdPlayer);
        amplifier.setSurroundSound();
        amplifier.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popcornPopper.off();
        theaterLights.on();
        screen.up();
        projector.off();
        amplifier.off();
        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.off();
    }
}
