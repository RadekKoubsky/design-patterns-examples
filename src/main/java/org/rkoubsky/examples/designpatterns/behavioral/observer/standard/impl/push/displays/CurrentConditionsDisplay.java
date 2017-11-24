package org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.displays;

import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.observers.Observer;
import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.subject.Subject;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.printf("Current conditions: %.2fF and %.2f%% humidity \n", temperature, humidity);
    }
}
