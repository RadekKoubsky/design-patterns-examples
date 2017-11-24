package org.rkoubsky.examples.designpatterns.behavioral.observer.java.observable.api.pull;

import org.rkoubsky.examples.designpatterns.behavioral.observer.java.observable.api.pull.displays.CurrentConditionsDisplay;
import org.rkoubsky.examples.designpatterns.behavioral.observer.java.observable.api.pull.displays.DisplayElement;
import org.rkoubsky.examples.designpatterns.behavioral.observer.java.observable.api.pull.displays.ForecastDisplay;
import org.rkoubsky.examples.designpatterns.behavioral.observer.java.observable.api.pull.displays.StatisticsDisplay;
import org.rkoubsky.examples.designpatterns.behavioral.observer.java.observable.api.pull.subject.WeatherData;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class WeatherStation {
    public static void main(final String[] args) {
        final WeatherData weatherData = new WeatherData();

        final DisplayElement currentDisplay = new CurrentConditionsDisplay(weatherData);
        final DisplayElement statisticsDisplay = new StatisticsDisplay(weatherData);
        final DisplayElement forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
