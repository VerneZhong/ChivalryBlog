package com.chivalry.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * RMI Server 实现
 *
 * @author Mr.zxb
 * @date 2020-08-16 15:20
 */
public class RMIServer {
    public static void main(String[] args) {
        try {
            RemoteHelloService helloService = new RemoteHelloServiceImpl();
            // 导出服务，使用4000端口
            RemoteHelloService stub = (RemoteHelloService) UnicastRemoteObject.exportObject(helloService, 4000);
            // 获取 Registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8000);
            // 注册 stub 服务
            registry.bind("hello", stub);
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
