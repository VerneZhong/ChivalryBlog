package com.chivalry.design.patterns.state;

/**
 * 糖果机
 * @author Mr.zxb
 * @date 2020-09-06 21:18:14
 */
public class GumballMachine {
    // 售罄
    public static final int SOLD_OUT = 0;
    // 没有投币
    public static final int NO_QUARTER = 1;
    // 已投币
    public static final int HAS_QUARTER = 2;
    // 售出
    public static final int SOLD = 3;

    // 当前状态
    private int state = SOLD_OUT;
    // 糖果数量
    private int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    /**
     * 投币方法
     */
    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("You can't insert another quarter.");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("You inserted a quarter.");
        } else if (state == SOLD_OUT) {
            System.out.println("You cant't insert a quarter, the machine is sold out.");
        } else if (state == SOLD) {
            System.out.println("Please wait, we're already giving you a gumball.");
        }
    }

    /**
     * 退币方法
     */
    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("Quarter returned.");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("You haven't inserted a quarter.");
        } else if (state == SOLD) {
            System.out.println("Sorry, you already turned the crank.");
        } else if (state == SOLD_OUT) {
            System.out.println("You can't eject, you haven't inserted a quarter yet.");
        }
    }

    /**
     * 转动曲柄方法
     */
    public void turnCrank() {
        if (state == SOLD) {
            System.out.println("Turning twice doesn't get you another gumball.");
        } else if (state == NO_QUARTER) {
            System.out.println("You turned but there's no quarter.");
        } else if (state == SOLD_OUT) {
            System.out.println("You turned, but there are no gumballs.");
        } else if (state == HAS_QUARTER) {
            System.out.println("You turned...");
            state = SOLD;
            dispense();
        }
    }

    /**
     * 发放糖果方法
     */
    public void dispense() {
        if (state == SOLD) {
            System.out.println("A gumball comes rolling out the solt.");
            count--;
            if (count == 0) {
                System.out.println("Oops, out of gumballs.");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
            System.out.println("You need to pay first.");
        } else if (state == SOLD_OUT) {
            System.out.println("No gumball dispensed.");
        } else if (state == HAS_QUARTER) {
            System.out.println("No gumball dispensed.");
        }
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
