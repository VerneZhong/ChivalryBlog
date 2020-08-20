package com.chivalry.rmi;

import java.rmi.RemoteException;

/**
 * 远程接口实现
 *
 * @author Mr.zxb
 * @date 2020-08-16 15:17
 */
public class RemoteHelloServiceImpl implements RemoteHelloService {
    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello " + name;
    }
}
