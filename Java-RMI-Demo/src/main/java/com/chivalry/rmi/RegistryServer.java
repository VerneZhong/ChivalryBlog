package com.chivalry.rmi;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;

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
            // 阻塞 RegistryServer
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
