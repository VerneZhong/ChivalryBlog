package com.chivalry.design.patterns.interpreter;

/**
 * 客户端，测试类
 * @author Mr.Zxb
 * @description
 * @date 2025/03/02 21:25
 */
public class InterpreterPatternDemo {
    public static void main(String[] args) {
        // 构造表达式：（3+5）*2
        Expression three = new NumberExpression(3);
        Expression five = new NumberExpression(5);
        Expression add = new AddExpression(three, five);
        Expression two = new NumberExpression(2);
        Expression multiply = new MultiplyExpression(add, two);

        // 解释表达式并计算结果
        System.out.println("计算结果：" + multiply.interpret());
    }
}
