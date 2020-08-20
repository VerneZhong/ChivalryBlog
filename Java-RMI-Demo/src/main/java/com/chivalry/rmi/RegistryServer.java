package com.chivalry.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * 注册中心的实现
 *
 * @author Mr.zxb
 * @date 2020-08-16 15:17
 */
public class RegistryServer {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(8000);
            System.out.println("registry start...");
            LockSupport.park();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
