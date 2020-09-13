package com.chivalry.rmi.examples;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程接口
 * @author Mr.zxb
 * @date 2020-09-13 16:41:00
 */
public interface AddServiceInterface extends Remote {
    int sum(int a, int b) throws RemoteException;
}
