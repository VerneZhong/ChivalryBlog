package com.chivalry.design.patterns.chain.responsibility;

/**
 * @author Mr.zxb
 * @date 2020-09-19 18:28:39
 */
public class Dollar50Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        // 处理50以上的货币
        if (currency.getAmount() >= 50) {
            int num = currency.getAmount() / 50;
            int remainder = currency.getAmount() % 50;
            System.out.println("Dispensing " + num + " 50$ note.");
            if (remainder != 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else {
            // 交给下一个链路处理
            this.chain.dispense(currency);
        }
    }
}
