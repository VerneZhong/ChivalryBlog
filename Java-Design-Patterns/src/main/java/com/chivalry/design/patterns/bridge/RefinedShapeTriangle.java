package com.chivalry.design.patterns.bridge;

/**
 * @author Mr.zxb
 * @date 2020-09-16 21:42:04
 */
public class RefinedShapeTriangle extends AbstractShape {
    public RefinedShapeTriangle(ColorImplementor color) {
        super(color);
    }

    @Override
    void applyShapeColor() {
        System.out.print("Triangle color applying...");
        color.applyColor();
    }
}
