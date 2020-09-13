package com.chivalry.rmi.examples;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Server
 * @author Mr.zxb
 * @date 2020-09-13 16:49:15
 */
public class AddServer {
    public static void main(String[] args) {
        try {
            AddServiceInterface addService = new Adder();

            // 导出服务，使用4000端口
            AddServiceInterface skeleton = (AddServiceInterface) UnicastRemoteObject.exportObject(addService, 5000);

            // 获取 Registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8000);

            // 注册 Skeleton 服务
            registry.bind("AddService", skeleton);
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
