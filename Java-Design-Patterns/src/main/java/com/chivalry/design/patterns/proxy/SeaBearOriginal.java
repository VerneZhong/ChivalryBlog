package com.chivalry.design.patterns.proxy;

/**
 * 原始对象
 * @author Mr.zxb
 * @date 2020-09-13 15:49:19
 */
public class SeaBearOriginal implements BearProtectInterface {
    @Override
    public void allowVisit(int visitorCode) {
        if (visitorCode == 1 ) {
            System.out.println("Visitor allowed to see the Sea Bear");
            this.showSeaBear();
        } else {
            System.out.println("Visitor NOT allowed to see the Sea Bear");
        }
    }

    public void showSeaBear(){
        System.out.println("You are welcome to the Sea Bear premisses");
    }
}
