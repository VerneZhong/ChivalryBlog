package com.chivalry.design.patterns.observer;

/**
 * 测试
 * @author Mr.zxb
 * @date 2020-08-11 20:59:32
 */
public class WeatherStationObservable {
    public static void main(String[] args) {
        // 气象主题，管理观察者，当有数据就通知已注册的观察者
        WeatherDataObservable weatherData = new WeatherDataObservable();

        // 观察者1
        CurrentConditionsDisplayObserver currentDisplay = new CurrentConditionsDisplayObserver();

        // 注册观察者
        weatherData.addObserver(currentDisplay);

        weatherData.setMeasurements(80, 56, 29.4f);
        weatherData.setMeasurements(82, 70, 39.2f);
    }
}
