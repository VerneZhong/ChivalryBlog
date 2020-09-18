package com.chivalry.sql.engine.presto.function;

/**
 * @author Mr.zxb
 * @date 2020-09-18 20:38:31
 */
public class SqlConstants {
    public static final String printAll = "select print() from status";

    public static final String store_to_dynamo = "select store_to_dynamo('all-group-jx-test-device_status') from +/+/status";

    public static final String store_to_sqs = "select store_to_sqs('all-group-test-jx1-life2-device-deviceId-event') from wifielement/+/status where type = 'deviceId'";
}
