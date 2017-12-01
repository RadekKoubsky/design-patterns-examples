package org.rkoubsky.examples.designpatterns.structural.facade;

import org.rkoubsky.examples.designpatterns.structural.facade.subsystem.components.Amplifier;
import org.rkoubsky.examples.designpatterns.structural.facade.subsystem.components.DvdPlayer;
import org.rkoubsky.examples.designpatterns.structural.facade.subsystem.components.Projector;
import org.rkoubsky.examples.designpatterns.structural.facade.subsystem.components.TheaterLights;

/**
 * The Client has on friend: the HomeTheaterFacade, thus it uses the Principle of Least Knowledge (Law of Demeter).
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class HomeTheaterTestDrive {
    public static void main(final String[] args) {
        final HomeTheaterFacade homeTheater = new HomeTheaterFacade(new Amplifier(), new DvdPlayer(), new Projector(),
                new TheaterLights());
        final String movie = "Star Wars: Episode VI - Return of the Jedi";
        homeTheater.watchMovie(movie);
        homeTheater.endMovie(movie);
    }
}
