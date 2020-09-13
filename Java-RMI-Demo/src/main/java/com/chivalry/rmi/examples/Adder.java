package com.chivalry.rmi.examples;

import java.rmi.RemoteException;

/**
 * 远程接口实现
 * @author Mr.zxb
 * @date 2020-09-13 16:43:01
 */
public class Adder implements AddServiceInterface {

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }
}
