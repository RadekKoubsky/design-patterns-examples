package org.rkoubsky.examples.designpatterns.structural.facade.subsystem.components;

/**
 * A component of a subsystem that is simplified by The Facade
 * ({@link org.rkoubsky.examples.designpatterns.structural.facade.HomeTheaterFacade})
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class Projector {
    public void on() {
        System.out.println("Projector on.");
    }

    public void off() {
        System.out.println("Projector off.");
    }

    public void wideScreenMode() {
        System.out.println("Projector widescreen mode (16x9 aspect ratio)");
    }
}
