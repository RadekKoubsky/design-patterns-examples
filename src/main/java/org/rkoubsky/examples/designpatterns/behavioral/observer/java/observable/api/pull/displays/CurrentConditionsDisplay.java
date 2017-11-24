package org.rkoubsky.examples.designpatterns.behavioral.observer.java.observable.api.pull.displays;

import org.rkoubsky.examples.designpatterns.behavioral.observer.java.observable.api.pull.subject.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private final Observable observable;

    public CurrentConditionsDisplay(final Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(final Observable obs, final Object arg) {
        if (obs instanceof WeatherData) {
            final WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.printf("Current conditions: %.2fF and %.2f%% humidity \n", this.temperature, this.humidity);
    }
}
