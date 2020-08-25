package com.chivalry.design.patterns.template.method;

/**
 * @author Mr.zxb
 * @date 2020-08-25 22:21:33
 */
public class BeverageTestDrive {
    public static void main(String[] args) {
        TeaWithHook teaWithHook = new TeaWithHook();

        System.out.println("Make tea...");
        teaWithHook.prepareRecipe();
    }
}
