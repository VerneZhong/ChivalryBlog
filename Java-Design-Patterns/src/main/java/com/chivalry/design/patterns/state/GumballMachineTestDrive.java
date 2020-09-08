package com.chivalry.design.patterns.state;

/**
 * @author Mr.zxb
 * @date 2020-09-06 21:45:34
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        // 创建装有5个糖果的糖果机
        GumballMachine gumballMachine = new GumballMachine(5);

        // 打印机器状态
        System.out.println(gumballMachine);

        // 投币
        gumballMachine.insertQuarter();
        // 转动曲柄
        gumballMachine.turnCrank();

        // 再次打印机器状态
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        gumballMachine.turnCrank();

        // 再次打印机器状态
        System.out.println(gumballMachine);
    }
}
