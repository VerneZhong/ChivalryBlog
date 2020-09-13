package com.chivalry.design.patterns.proxy;

/**
 * 代理对象
 *
 * @author Mr.zxb
 * @date 2020-09-13 15:48:09
 */
public class SeaBearGuardProxy implements BearProtectInterface {

    private int visitorCode;
    private String visitorProfession;
    private SeaBearOriginal seaBear = new SeaBearOriginal();

    @Override
    public void allowVisit(int visitorCode) {
        if (visitorCode == 1) {
            System.out.println("Visitor allowed to see the Sea Bear");
            seaBear.showSeaBear();
        } else {
            System.out.println("Visitor NOT allowed to see the Sea Bear");
        }
    }

    public void assignVisitorCode(String profession) {
        if (visitorProfession == "Biologist" || visitorProfession == "Vet" || visitorProfession == "Animal Researcher") {
            visitorCode = 1;
        } else {
            visitorCode = 0;
        }
    }
}
