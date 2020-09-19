package com.chivalry.design.patterns.flyweight;

import java.awt.Graphics;
import java.awt.Color;

/**
 * 图形接口
 * @author Mr.zxb
 * @date 2020-09-19 19:36:10
 */
public interface Shape {
    /**
     * 绘画方法
     * @param g
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    void draw(Graphics g, int x, int y, int width, int height, Color color);
}
