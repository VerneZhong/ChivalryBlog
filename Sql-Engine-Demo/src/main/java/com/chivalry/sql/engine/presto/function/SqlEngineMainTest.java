package com.chivalry.sql.engine.presto.function;

/**
 * @author Mr.zxb
 * @date 2020-09-18 21:44:35
 */
public class SqlEngineMainTest {
    public static void main(String[] args) {
        String topic = "wifielement/B0:F8:93:66:07:13/status";
        String payload = "{\"dn\":\"B0:F8:93:66:07:13\", \"type\":\"timeZone\", \"value\": \"Asia/Shanghai\"}";
        EngineUtils.process(topic, payload);
    }
}
