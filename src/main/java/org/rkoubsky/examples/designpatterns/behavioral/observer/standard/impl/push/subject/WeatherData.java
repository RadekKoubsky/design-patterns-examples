package org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.subject;

import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.observers.Observer;

import java.util.LinkedList;
import java.util.List;

/**
 * A ConcreteSubject always implements the Subject ({@link Subject}) interface.
 * In addition to the register and remove methods, the concrete subject implements
 * a {@link Subject#notifyObservers()} method that is used to update all
 * the current observers whenever state changes.
 *
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class WeatherData implements Subject {
    private final List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new LinkedList<>();
    }

    @Override
    public void registerObserver(final Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(final Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(observer -> observer.update(this.temperature, this.humidity, this.pressure));
    }

    public void measurementChanged() {
        notifyObservers();
    }

    public void setMeasurements(final float temp, final float humidity, final float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}
