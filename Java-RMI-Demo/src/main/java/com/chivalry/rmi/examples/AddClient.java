package com.chivalry.rmi.examples;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Client
 * @author Mr.zxb
 * @date 2020-09-13 16:52:32
 */
public class AddClient {
    public static void main(String[] args) {
        try {
            // 获取注册中心
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8000);

            //  查找远程服务
            AddServiceInterface stub = (AddServiceInterface) registry.lookup("AddService");

            // 访问远程服务
            System.out.println("result = " + stub.sum(5, 5));
        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
