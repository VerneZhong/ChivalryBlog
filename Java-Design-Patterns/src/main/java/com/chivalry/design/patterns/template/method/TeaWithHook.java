package com.chivalry.design.patterns.template.method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 茶
 * @author Mr.zxb
 * @date 2020-08-25 21:41:18
 */
public class TeaWithHook extends CaffeineBeverageWithHook {

    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Lemon");
    }

    /**
     * 覆盖钩子，实现自己的功能，根据用户输入，是否需要添加配料
     * @return
     */
    @Override
    boolean customerWantsCondiments() {
        return getUserInput().toLowerCase().startsWith("y");
    }

    /**
     * 获取用户是否要加调料
     * @return
     */
    private String getUserInput() {
        System.out.print("Would you like lemon with your tea (y/n)?");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "no";
    }
}
