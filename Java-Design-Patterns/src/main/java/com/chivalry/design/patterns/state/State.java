package com.chivalry.design.patterns.state;

/**
 * 状态接口
 * @author Mr.zxb
 * @date 2020-09-06 22:00:14
 */
public interface State {
    /**
     * 投币
     */
    void insertQuarter();

    /**
     * 退币方法
     */
    void ejectQuarter();

    /**
     * 转动曲柄方法
     */
    void turnCrank();

    /**
     * 发放糖果方法
     */
    void dispense();
}
