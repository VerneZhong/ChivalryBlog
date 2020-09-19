package com.chivalry.design.patterns.composite;

/**
 * @author Mr.zxb
 * @date 2020-09-19 20:32:20
 */
public class TestCompositePattern {
    public static void main(String[] args) {
        // create instance
        Shape tri = new Triangle();
        Shape tri1 = new Triangle();
        Shape cir = new Circle();

        Drawing drawing = new Drawing();
        drawing.add(tri1);
        drawing.add(tri1);
        drawing.add(cir);

        // draw shape
        drawing.draw("Red");

        // clear
        drawing.clear();

        drawing.add(tri);
        drawing.add(cir);
        drawing.draw("Green");
    }
}
