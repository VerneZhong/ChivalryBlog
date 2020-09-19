package com.chivalry.design.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 图形工厂方法
 * @author Mr.zxb
 * @date 2020-09-19 19:44:23
 */
public class ShapeFactory {
    public static final Map<ShapeType, Shape> SHAPES = new HashMap<>();

    public static Shape getShape(ShapeType type) {
        Shape shape = SHAPES.get(type);
        if (shape == null) {
            if (type.equals(ShapeType.OVAL_FILL)) {
                shape = new Oval(true);
            } else if (type.equals(ShapeType.OVAL_NOFILL)) {
                shape = new Oval(false);
            } else if (type.equals(ShapeType.LINE)) {
                shape = new Line();
            }
            SHAPES.put(type, shape);
        }
        return shape;
    }
}
