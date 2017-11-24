package org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.subject;

import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.observers.Observer;

import java.util.LinkedList;
import java.util.List;

/**
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
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(temperature, humidity, pressure));
    }

    public void measurementChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure){
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}
