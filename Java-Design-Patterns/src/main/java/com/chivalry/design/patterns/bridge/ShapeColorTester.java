package com.chivalry.design.patterns.bridge;

/**
 * @author Mr.zxb
 * @date 2020-09-16 21:44:30
 */
public class ShapeColorTester {
    public static void main(String[] args) {
        // 创建Triangle实例并应用红色
        System.out.println("Apply Red Color to the Triangle");
        AbstractShape triangle = new RefinedShapeTriangle(new ConcreteColorRed());
        triangle.applyShapeColor();

        // 创建Triangle实例并应用绿色
        System.out.println("Appying Green Color to the Triangle");
        AbstractShape triagleGreen = new RefinedShapeTriangle(new ConcreteColorGreen());
        triagleGreen.applyShapeColor();

        // 创建Circle实例并应用红色
        System.out.println("Appying Red Color to the Circle");
        AbstractShape circleRed = new RefinedShapeCircle(new ConcreteColorRed());
        circleRed.applyShapeColor();

        // 创建Circle实例并应用绿色
        System.out.println("Applying Green Color to the Circle");
        AbstractShape circleGreen = new RefinedShapeCircle(new ConcreteColorGreen());
        circleGreen.applyShapeColor();
    }
}
