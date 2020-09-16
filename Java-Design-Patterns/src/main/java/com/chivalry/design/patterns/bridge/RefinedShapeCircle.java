package com.chivalry.design.patterns.bridge;

/**
 * @author Mr.zxb
 * @date 2020-09-16 21:40:50
 */
public class RefinedShapeCircle extends AbstractShape {
    public RefinedShapeCircle(ColorImplementor color) {
        super(color);
    }

    @Override
    void applyShapeColor() {
        System.out.println("Circle color applying...");
        color.applyColor();
    }
}
