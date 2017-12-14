package org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.displays;

import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.observers.Observer;
import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.subject.Subject;

/**
 * A ConcreteObserver can be any class that implements the Observer interface ({@link Observer}).
 * Each observer registers a concrete subject to receive updates.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private final Subject weatherData;

    public CurrentConditionsDisplay(final Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(final float temperature, final float humidity, final float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.printf("Current conditions: %.2fF and %.2f%% humidity \n", this.temperature, this.humidity);
    }
}
