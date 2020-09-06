package com.chivalry.design.patterns.state.v2;

import com.chivalry.design.patterns.state.*;

/**
 * 糖果机
 * @author Mr.zxb
 * @date 2020-09-06 21:18:14
 */
public class GumballMachine {
    // 售罄
    private State soldOutState;
    // 没有投币
    private State noQuarterState;
    // 已投币
    private State hasQuarterState;
    // 售出
    private State soldState;

    // 赢家
    private State winnerState;

    // 当前状态
    private State state = soldOutState;
    // 糖果数量
    private int count = 0;

    public GumballMachine(int count) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = count;
        if (count > 0) {
            state = noQuarterState;
        }
    }

    /**
     * 投币方法
     */
    public void insertQuarter() {
        state.insertQuarter();
    }

    /**
     * 退币方法
     */
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    /**
     * 转动曲柄方法
     */
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    /**
     * 发放糖果方法
     */
    public void dispense() {
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot.");
        if (count != 0) {
            count--;
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public int getCount() {
        return count;
    }

    public State getWinnerState() {
        return winnerState;
    }
}
