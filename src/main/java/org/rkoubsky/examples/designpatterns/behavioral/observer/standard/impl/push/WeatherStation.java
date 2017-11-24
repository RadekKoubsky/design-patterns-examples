package org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push;

import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.displays.CurrentConditionsDisplay;
import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.displays.DisplayElement;
import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.displays.ForecastDisplay;
import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.displays.StatisticsDisplay;
import org.rkoubsky.examples.designpatterns.behavioral.observer.standard.impl.push.subject.WeatherData;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        DisplayElement currentDisplay = new CurrentConditionsDisplay(weatherData);
        DisplayElement statisticsDisplay = new StatisticsDisplay(weatherData);
        DisplayElement forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
