package com.chivalry.design.patterns.interpreter;

/**
 * 非终结符表达式（乘法）
 * @author Mr.Zxb
 * @description
 * @date 2025/03/02 21:24
 */
public class MultiplyExpression implements Expression {

    private final Expression left, right;

    public MultiplyExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() * right.interpret();
    }
}
