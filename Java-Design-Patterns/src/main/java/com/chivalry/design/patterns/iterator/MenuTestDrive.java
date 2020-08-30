package com.chivalry.design.patterns.iterator;

import java.util.ArrayList;

/**
 * @author Mr.zxb
 * @date 2020-08-30 21:31:44
 */
public class MenuTestDrive {
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }
}
