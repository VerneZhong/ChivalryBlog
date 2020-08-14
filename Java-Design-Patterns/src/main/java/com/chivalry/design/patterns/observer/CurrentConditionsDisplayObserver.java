package com.chivalry.design.patterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 * @author Mr.zxb
 * @date 2020-08-11 20:51:29
 */
public class CurrentConditionsDisplayObserver implements Observer, DisplayElement {

    private float temperature;
    private float humidity;


    @Override
    public void display() {
        System.out.printf("Current Conditions: %s F degrees and %s %% humidity.\n", temperature, humidity);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherDataObservable) {
            WeatherDataObservable weatherDataObservable = (WeatherDataObservable) o;
            this.temperature = weatherDataObservable.getTemperature();
            this.humidity = weatherDataObservable.getHumidity();

            this.display();
        }
    }
}
