package com.chivalry.design.patterns.mediator;

/**
 * 测试main方法
 * @author Mr.Zxb
 * @description
 * @date 2025/02/28 22:00
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();

        Airplane plane1 = new Boeing737(tower);
        Airplane plane2 = new AirbusA320(tower);

        tower.registerAirplane(plane1);
        tower.registerAirplane(plane2);

        plane1.sendMessage("请求起飞🛫");
        plane2.sendMessage("请求降落🛬");
    }
}
