package com.chivalry.java.basic;

/**
 * @author Mr.Zxb
 * @description
 * @date 2023/11/18 20:43
 */
public class Test2 {
    private int score = 300;
    private int point = 0;

    private void applyScore(int sc) {
        int point = sc;
        score = point;
    }

    public void printResult() {
        int score = point;
        System.out.println(score + " : " + point);
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        t.applyScore(500);
        t.printResult();
    }
}
