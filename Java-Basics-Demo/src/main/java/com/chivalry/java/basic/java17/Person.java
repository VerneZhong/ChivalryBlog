package com.chivalry.java.basic.java17;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author verne.zhong
 * @description
 * @date 2023/08/20 13:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private String address;
}
