package com.chivalry.design.patterns.proxy;

/**
 * 客户端对象
 * @author Mr.zxb
 * @date 2020-09-13 15:51:53
 */
public class NatureParkVisitorClient {
    public static void main(String[] args) {
        // 创建代理对象
        BearProtectInterface seaBearProxy = new SeaBearGuardProxy();
        try {
            // 调用接口
            seaBearProxy.allowVisit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
