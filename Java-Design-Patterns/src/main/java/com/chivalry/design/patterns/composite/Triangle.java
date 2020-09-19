package com.chivalry.design.patterns.composite;

/**
 * @author Mr.zxb
 * @date 2020-09-19 20:29:00
 */
public class Triangle implements Shape {
    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle with color " + fillColor);
    }
}
