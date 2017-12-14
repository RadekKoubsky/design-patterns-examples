package org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.displays;

import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.observers.Observer;
import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.subject.Subject;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private final Subject weatherData;

    public ForecastDisplay(final Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(final float temp, final float humidity, final float pressure) {
        this.lastPressure = this.currentPressure;
        this.currentPressure = pressure;
        display();
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
