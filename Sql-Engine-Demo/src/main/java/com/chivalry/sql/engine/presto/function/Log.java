package com.chivalry.sql.engine.presto.function;

/**
 * sql log(*)
 * @author Mr.zxb
 * @date 2020-09-17 22:02:48
 */
public class Log {
    @SqlFunction(name = "print", param = ParameterFrom.RAWJSON)
    public static void print(String topic, String message) {
        System.out.printf("SQLLOG:INFO: topic=%s, message=%s", topic, message);
    }
}
