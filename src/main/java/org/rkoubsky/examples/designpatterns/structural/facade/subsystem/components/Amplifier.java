package org.rkoubsky.examples.designpatterns.structural.facade.subsystem.components;

/**
 * A component of a subsystem that is simplified by The Facade
 * ({@link org.rkoubsky.examples.designpatterns.structural.facade.HomeTheaterFacade})
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Amplifier {
    public void on() {
        System.out.println("Amplifier on.");
    }

    public void off() {
        System.out.println("Amplifier off.");
    }

    public void setSurround() {
        System.out.println("Amplifier surround sound on (5 speakers, 1 subwoofer)");
    }

    public void setVolume(final int volume) {
        System.out.println("Amplifier setting volume to 5.");
    }
}
