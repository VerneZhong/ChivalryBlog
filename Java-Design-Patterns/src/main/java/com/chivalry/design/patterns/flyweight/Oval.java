package com.chivalry.design.patterns.flyweight;

import java.awt.Graphics;
import java.awt.Color;
import java.util.concurrent.TimeUnit;

/**
 * 椭圆形
 * @author Mr.zxb
 * @date 2020-09-19 19:37:30
 */
public class Oval implements Shape {

    /**
     * intrinsic property
     */
    private boolean fill;

    public Oval(boolean fill) {
        this.fill = fill;
        System.out.println("Creating Oval object with fill = " + fill);

        // adding time delay
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics circle, int x, int y, int width, int height, Color color) {
        circle.setColor(color);
        circle.drawOval(x, y, width, height);
        if (fill) {
            circle.fillOval(x, y, width, height);
        }
    }
}
