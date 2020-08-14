package com.chivalry.design.patterns.observer;

/**
 * @author Mr.zxb
 * @date 2020-08-11 20:41:26
 */
public interface Observer {
    /**
     * 更新气象值改变时，传递给观察者
     * @param temperature
     * @param humidity
     * @param pressure
     */
    void update(float temperature, float humidity, float pressure);
}
