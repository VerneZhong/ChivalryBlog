package com.chivalry.design.patterns.observer;

import java.util.Observable;

/**
 * @author Mr.zxb
 * @date 2020-08-11 20:11:46
 */
public class WeatherDataObservable extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    /**
     * 一旦气象测量更新，此方法就会被调用
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        // 获取温度、湿度、气压
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        // 指示状态已经改变
        super.setChanged();
        // 通知观察者
        super.notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
