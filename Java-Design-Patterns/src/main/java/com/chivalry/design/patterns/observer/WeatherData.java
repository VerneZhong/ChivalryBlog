package com.chivalry.design.patterns.observer;

import java.util.ArrayList;

/**
 * @author Mr.zxb
 * @date 2020-08-11 20:11:46
 */
public class WeatherData implements Subject {

    private final ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    /**
     * 一旦气象测量更新，此方法就会被调用
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        // 获取温度、湿度、气压
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        // 通知观察者
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i > 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}
