package com.chivalry.design.patterns.observer;

/**
 * @author Mr.zxb
 * @date 2020-08-11 20:59:32
 */
public class WeatherStation {
    public static void main(String[] args) {
        // 气象主题，管理观察者，当有数据就通知已注册的观察者
        WeatherData weatherData = new WeatherData();

        // 观察者1
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        // 观察者1
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        // 观察者1
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 56, 29.4f);
        weatherData.setMeasurements(82, 70, 39.2f);
        weatherData.setMeasurements(75, 90, 20.1f);
    }
}
