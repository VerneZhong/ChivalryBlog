package com.chivalry.design.patterns.prototype;

import java.util.List;

/**
 * 测试原型模式
 *
 * @author Mr.zxb
 * @date 2020-09-15 16:57
 */
public class PrototypePatternTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 创建 Employees 实例
        Employees employees = new Employees();
        // 加载数据
        employees.loadDate();

        // 使用 clone方法来获取 Employees对象
        Employees empsNew = (Employees) employees.clone();
        Employees empsNew1 = (Employees) employees.clone();
        List<String> list = empsNew.getEmpList();
        list.add("John");
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("David");

        System.out.println("employees List: "+ employees.getEmpList());
        System.out.println("empsNew List: " + list);
        System.out.println("empsNew1 List: " + list1);
    }
}
