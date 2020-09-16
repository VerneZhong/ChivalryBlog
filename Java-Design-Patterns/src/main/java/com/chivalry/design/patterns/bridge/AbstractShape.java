package com.chivalry.design.patterns.bridge;

/**
 * @author Mr.zxb
 * @date 2020-09-16 21:39:21
 */
public abstract class AbstractShape {

    /**
     * 创建实现者实例（组成）
     */
    protected ColorImplementor color;

    /**
     * 以实现者作为输入参数的构造函数
     * @param color
     */
    public AbstractShape(ColorImplementor color) {
        this.color = color;
    }

    /**
     * 与将颜色填充到对象有关的抽象方法
     */
    abstract void applyShapeColor();
}
