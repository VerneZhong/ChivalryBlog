package com.chivalry.design.patterns.interpreter;

/**
 * 非终结符表达式（加法）
 * @author Mr.Zxb
 * @description
 * @date 2025/03/02 21:23
 */
public class AddExpression implements Expression {

    private final Expression left, right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}
