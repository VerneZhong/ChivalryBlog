package com.chivalry.design.patterns.visitor;

/**
 * @author Mr.zxb
 * @date 2020-09-19 18:55:46
 */
public interface ShoppingCartVisitor {
    /**
     * 访问方法
     * @param element
     * @return
     */
    int visit(ItemElement element);
}
