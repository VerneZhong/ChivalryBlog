package com.chivalry.spring.boot.examples.order;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author verne.zhong
 * @description
 * @date 2023/08/19 15:06
 */
@Data
@Builder
public class Order {
    private long orderId;
    private String orderName;
    private LocalDateTime createTime;
}
