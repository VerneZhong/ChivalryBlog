package com.chivalry.spring.boot.examples;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * class
 *
 * @author Mr.zxb
 * @date 2020-08-19 16:55
 */
@SpringBootApplication
@AllArgsConstructor
@RestController
public class SpringBootDemo {

    private final KafkaProvider kafkaProvider;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo.class, args);
    }

    @GetMapping
    public String sendMessage(@RequestParam("orderId") long orderId, @RequestParam("orderName") String orderName) {
        kafkaProvider.sendMessage(orderId, orderName, LocalDateTime.now());
        return "OK";
    }
}
