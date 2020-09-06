package com.chivalry.design.patterns.state;

import com.chivalry.design.patterns.state.v2.GumballMachine;

import java.util.Random;

/**
 * 已投币状态
 * @author Mr.zxb
 * @date 2020-09-06 22:09:08
 */
public class HasQuarterState implements State {

    private final GumballMachine gumballMachine;

    private Random random = new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned.");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = random.nextInt(10);
        if (winner == 0 && gumballMachine.getCount() > 1) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed.");
    }
}
