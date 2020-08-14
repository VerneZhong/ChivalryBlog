package com.chivalry.design.patterns.observer;

/**
 * @author Mr.zxb
 * @date 2020-08-11 20:51:29
 */
public class ForecastDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;

    @Override
    public void display() {
        System.out.printf("Current Conditions: %s F degrees and %s %% humidity.\n", temperature, humidity);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
