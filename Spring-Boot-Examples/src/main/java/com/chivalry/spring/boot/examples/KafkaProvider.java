package com.chivalry.spring.boot.examples;

import com.alibaba.fastjson.JSONObject;
import com.chivalry.spring.boot.examples.order.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

/**
 * @author verne.zhong
 * @description
 * @date 2023/08/19 15:07
 */
@Component
public class KafkaProvider {
    public static final String TOPIC = "shopping";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProvider(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(long orderId, String orderName, LocalDateTime dateTime) {
        Order order = Order.builder()
                .orderId(orderId)
                .orderName(orderName)
                .createTime(dateTime)
                .build();

        CompletableFuture.runAsync(() -> kafkaTemplate.send(TOPIC, JSONObject.toJSONString(order)));
    }
}
