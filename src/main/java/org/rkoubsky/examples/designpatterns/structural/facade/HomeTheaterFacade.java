package org.rkoubsky.examples.designpatterns.structural.facade;

import org.rkoubsky.examples.designpatterns.structural.facade.subsystem.components.Amplifier;
import org.rkoubsky.examples.designpatterns.structural.facade.subsystem.components.DvdPlayer;
import org.rkoubsky.examples.designpatterns.structural.facade.subsystem.components.Projector;
import org.rkoubsky.examples.designpatterns.structural.facade.subsystem.components.TheaterLights;

/**
 * The Facade class treats the home theater components as a subsystem, and calls on the subsystem
 * to implement the {@code watchMovie()} method.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class HomeTheaterFacade {
    private final Amplifier amp;
    private final DvdPlayer dvd;
    private final Projector projector;
    private final TheaterLights theaterLights;

    public HomeTheaterFacade(final Amplifier amp, final DvdPlayer dvd, final Projector projector,
            final TheaterLights theaterLights) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.theaterLights = theaterLights;
    }

    public void watchMovie(final String movie) {
        System.out.println("Get ready to watch a movie...");
        this.theaterLights.dim(10);
        this.projector.on();
        this.projector.wideScreenMode();
        this.amp.on();
        this.amp.setSurround();
        this.amp.setVolume(5);
        this.dvd.on();
        this.dvd.play(movie);
    }

    public void endMovie(final String movie) {
        System.out.println("Shuting movie theater down...");
        this.theaterLights.on();
        this.projector.off();
        this.amp.off();
        this.dvd.stop(movie);
        this.dvd.eject();
        this.dvd.off();
    }
}
