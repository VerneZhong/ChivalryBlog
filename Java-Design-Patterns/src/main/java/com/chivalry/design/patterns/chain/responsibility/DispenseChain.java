package com.chivalry.design.patterns.chain.responsibility;

/**
 * 分配链
 * @author Mr.zxb
 * @date 2020-09-19 18:22:48
 */
public interface DispenseChain {
    /**
     * 设置下一个分配链
     * @param nextChain
     */
    void setNextChain(DispenseChain nextChain);

    /**
     * 分配
     * @param currency
     */
    void dispense(Currency currency);
}
