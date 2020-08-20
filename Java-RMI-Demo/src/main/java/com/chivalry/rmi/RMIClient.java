package com.chivalry.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI Client 实现
 *
 * @author Mr.zxb
 * @date 2020-08-16 15:23
 */
public class RMIClient {
    public static void main(String[] args) {
        try {
            // 获取注册中心
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8000);
            // 查找远程服务
            RemoteHelloService remoteHelloService = (RemoteHelloService) registry.lookup("hello");
            // 调用远程服务
            System.out.println(remoteHelloService.sayHello("RMI"));
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
