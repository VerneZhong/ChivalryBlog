package com.chivalry.springboot.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author verne.zhong
 * @description
 * @date 2023/08/19 15:29
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "shopping", groupId = "group_id")
    public void consumer(String message) {
        System.out.println("消费者消费信息 ## consumer message: {}" +message);
    }
}
