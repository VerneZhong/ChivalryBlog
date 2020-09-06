package com.chivalry.design.patterns.state;

import com.chivalry.design.patterns.state.v2.GumballMachine;

/**
 * 售罄状态
 * @author Mr.zxb
 * @date 2020-09-06 22:08:39
 */
public class SoldOutState implements State {

    private final GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet.");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs.");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed.");
    }
}
