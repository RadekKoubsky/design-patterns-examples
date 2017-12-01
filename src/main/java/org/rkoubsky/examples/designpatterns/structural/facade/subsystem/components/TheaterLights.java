package org.rkoubsky.examples.designpatterns.structural.facade.subsystem.components;

/**
 * A component of a subsystem that is simplified by The Facade
 * ({@link org.rkoubsky.examples.designpatterns.structural.facade.HomeTheaterFacade})
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class TheaterLights {
    public void on() {
        System.out.println("Theater Ceiling Lights on.");
    }

    public void dim(final int percent) {
        System.out.println(String.format("Theater Ceiling Lights dimming to %s%%", percent));
    }
}
