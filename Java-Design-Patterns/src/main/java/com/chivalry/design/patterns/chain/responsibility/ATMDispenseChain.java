package com.chivalry.design.patterns.chain.responsibility;

import java.util.Scanner;

/**
 * ATM机责任链模式示例
 * @author Mr.zxb
 * @date 2020-09-19 18:39:52
 */
public class ATMDispenseChain {

    private final DispenseChain chainFirst;

    public ATMDispenseChain() {
        // initialize the chain
        chainFirst = new Dollar50Dispenser();
        DispenseChain chain2 = new Dollar20Dispenser();
        DispenseChain chain3 = new Dollar10Dispenser();

        // set the chain of responsibility
        chainFirst.setNextChain(chain2);
        chain2.setNextChain(chain3);
    }

    public void dispense(Currency currency) {
        this.chainFirst.dispense(currency);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenseChain = new ATMDispenseChain();
        while (true) {
            System.out.println("Enter amount to dispense.");
            Scanner input = new Scanner(System.in);
            int amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atmDispenseChain.dispense(new Currency(amount));
        }
    }
}
