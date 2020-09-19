package com.chivalry.design.patterns.flyweight;

import java.awt.Graphics;
import java.awt.Color;
import java.util.concurrent.TimeUnit;

/**
 * 线
 * @author Mr.zxb
 * @date 2020-09-19 19:37:13
 */
public class Line implements Shape {

    public Line() {
        System.out.println("Creating Line object.");
        // adding time delay
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics line, int x, int y, int width, int height, Color color) {
        line.setColor(color);
        line.drawLine(x, y, width, height);
    }
}
