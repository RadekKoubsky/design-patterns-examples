package org.rkoubsky.examples.designpatterns.behavioral.observer.displays;

import org.rkoubsky.examples.designpatterns.behavioral.observer.observers.Observer;
import org.rkoubsky.examples.designpatterns.behavioral.observer.subject.Subject;
import org.rkoubsky.examples.designpatterns.behavioral.observer.subject.WeatherData;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        tempSum += temp;
        numReadings++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }

        if (temp < minTemp) {
            minTemp = temp;
        }
        display();
    }

    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }
}
