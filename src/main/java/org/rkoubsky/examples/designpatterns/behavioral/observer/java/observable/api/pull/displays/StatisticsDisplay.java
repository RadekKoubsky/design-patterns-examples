package org.rkoubsky.examples.designpatterns.behavioral.observer.java.observable.api.pull.displays;

import org.rkoubsky.examples.designpatterns.behavioral.observer.java.observable.api.pull.subject.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private final Observable observable;

    public StatisticsDisplay(final Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    /**
     * We are passing the Observable object ({@link WeatherData}) and optional
     * data argument. This approach is called Pull as the observers pull
     * the state from the Observable/Subject.
     */
    @Override
    public void update(final Observable obs, final Object arg) {
        if (obs instanceof WeatherData) {
            final WeatherData weatherData = (WeatherData) obs;
            final float temp = weatherData.getTemperature();
            this.tempSum += temp;
            this.numReadings++;

            if (temp > this.maxTemp) {
                this.maxTemp = temp;
            }

            if (temp < this.minTemp) {
                this.minTemp = temp;
            }
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (this.tempSum / this.numReadings)
                + "/" + this.maxTemp + "/" + this.minTemp);
    }
}
