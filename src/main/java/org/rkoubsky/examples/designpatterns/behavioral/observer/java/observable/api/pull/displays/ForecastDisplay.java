package org.rkoubsky.examples.designpatterns.behavioral.observer.java.observable.api.pull.displays;

import org.rkoubsky.examples.designpatterns.behavioral.observer.java.observable.api.pull.subject.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private final Observable observable;

    public ForecastDisplay(final Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(final Observable obs, final Object arg) {
        if (obs instanceof WeatherData) {
            final WeatherData weatherData = (WeatherData) obs;
            this.lastPressure = this.currentPressure;
            this.currentPressure = ((WeatherData) obs).getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (this.currentPressure > this.lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (this.currentPressure == this.lastPressure) {
            System.out.println("More of the same");
        } else if (this.currentPressure < this.lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}
