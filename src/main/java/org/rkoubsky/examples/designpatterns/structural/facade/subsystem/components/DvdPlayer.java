package org.rkoubsky.examples.designpatterns.structural.facade.subsystem.components;

/**
 * A component of a subsystem that is simplified by The Facade
 * ({@link org.rkoubsky.examples.designpatterns.structural.facade.HomeTheaterFacade})
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class DvdPlayer {
    public void on() {
        System.out.println("DVD Player on.");
    }

    public void off() {
        System.out.println("DVD Player off.");
    }

    public void play(final String movie) {
        System.out.println(String.format("DVD Player playing '%s'", movie));
    }

    public void stop(final String movie) {
        System.out.println(String.format("DVD Player stopped '%s'", movie));

    }

    public void eject() {
        System.out.println("DVD Player Eject");
    }
}
