package com.chivalry.design.patterns.observer;

/**
 * @author Mr.zxb
 * @date 2020-08-11 20:40:19
 */
public interface Subject {
    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 当主题状态改变时，该方法被调用，以通知所有观察者
     */
    void notifyObservers();
}
