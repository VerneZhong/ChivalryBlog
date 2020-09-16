package com.chivalry.design.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工类
 *
 * @author Mr.zxb
 * @date 2020-09-15 16:50
 */
public class Employees implements Cloneable {
    private List<String> empList;

    public Employees() {
        this.empList = new ArrayList<>();
    }

    public Employees(List<String> empList) {
        this.empList = empList;
    }

    public void loadDate() {
        // 从数据库中读取所有员工并放入列表
        empList.add("Lisa");
        empList.add("David");
        empList.add("Allen");
        empList.add("Helen");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Employees(new ArrayList<>(this.getEmpList()));
    }
}
