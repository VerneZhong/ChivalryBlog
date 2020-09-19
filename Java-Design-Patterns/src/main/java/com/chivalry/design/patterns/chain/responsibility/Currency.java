package com.chivalry.design.patterns.chain.responsibility;

/**
 * 货币
 * @author Mr.zxb
 * @date 2020-09-19 18:22:02
 */
public class Currency {
    private final int amount;

    public Currency(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
