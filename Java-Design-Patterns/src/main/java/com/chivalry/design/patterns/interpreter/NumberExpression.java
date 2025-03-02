package com.chivalry.design.patterns.interpreter;

/**
 * 终结符表达式（数字）
 * @author Mr.Zxb
 * @description
 * @date 2025/03/02 21:22
 */
public class NumberExpression  implements Expression {

    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}
