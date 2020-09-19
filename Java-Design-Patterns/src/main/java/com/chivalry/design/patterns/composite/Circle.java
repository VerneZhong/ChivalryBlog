package com.chivalry.design.patterns.composite;

/**
 * @author Mr.zxb
 * @date 2020-09-19 20:29:32
 */
public class Circle implements Shape {
    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Circle with color " + fillColor);
    }
}
