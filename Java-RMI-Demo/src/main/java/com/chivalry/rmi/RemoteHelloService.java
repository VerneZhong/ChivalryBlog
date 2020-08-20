package com.chivalry.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 定义远程接口
 *
 * @author Mr.zxb
 * @date 2020-08-16 15:15
 */
public interface RemoteHelloService extends Remote {
    String sayHello(String name) throws RemoteException;
}
