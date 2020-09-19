package com.chivalry.design.patterns.visitor;

/**
 * @author Mr.zxb
 * @date 2020-09-19 18:55:06
 */
public interface ItemElement {
    int accept(ShoppingCartVisitor visitor);
}
