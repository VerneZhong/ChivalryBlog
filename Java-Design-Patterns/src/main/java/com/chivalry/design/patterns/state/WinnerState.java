package com.chivalry.design.patterns.state;

import com.chivalry.design.patterns.state.v2.GumballMachine;

/**
 * 幸运玩家状态
 * @author Mr.zxb
 * @date 2020-09-06 22:20:51
 */
public class WinnerState implements State {

    private final GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        // 省略...
    }

    @Override
    public void ejectQuarter() {
        // 省略...
    }

    @Override
    public void turnCrank() {
        // 省略...
    }

    @Override
    public void dispense() {
        System.out.println("YOU'RE A WINNER! You get two gumballs for you quarter.");
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
             gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.releaseBall();
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs！");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
