package com.chivalry.design.patterns.template.method;

/**
 * 咖啡因饮料抽象类
 * @author Mr.zxb
 * @date 2020-08-25 21:52:53
 */
public abstract class CaffeineBeverageWithHook {
    /**
     * 我们不希望子类修改这个方法
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        // 如果顾客想要调料，才调用添加调料的方法
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /**
     * 冲泡，因为咖啡和茶的冲泡方法不一样，交给子类去实现
     */
    protected abstract void brew();

    /**
     * 添加调味品，子类可以自定义添加调味品
     */
    protected abstract void addCondiments();

    /**
     * 装杯
     */
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * 烧水
     */
    private void boilWater() {
        System.out.println("Boiling water");
    }

    /**
     * 这是一个钩子，子类可以覆盖这个方法， 但不见得要这么做
     * @return
     */
    boolean customerWantsCondiments() {
        return true;
    }
}
