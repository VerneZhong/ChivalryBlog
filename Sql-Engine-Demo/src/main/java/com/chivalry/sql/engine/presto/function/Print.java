package com.chivalry.sql.engine.presto.function;

/**
 * @author Mr.zxb
 * @date 2020-09-17 22:02:48
 */
public class Print {
    @SqlFunction(name = "print", param = ParameterFrom.RAWJSON)
    public static void print(String json) {
        System.out.println("log: " + json);
    }
}
