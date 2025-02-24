package com.chivalry.spring.boot.examples.test;

import com.chivalry.spring.boot.examples.order.DiscountService;
import com.chivalry.spring.boot.examples.order.DiscountServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Mr.Zxb
 * @description
 * @date 2024/10/12 20:15
 */
public class DiscountServiceSeniorTest {
    private final DiscountService discountService = new DiscountServiceImpl();

    @Test
    public void testSeniorDiscount() {
        double price = 100.0;
        String userType = "senior";
        double discountedPrice = discountService.applyDiscount(price, userType);
        assertEquals(70.0, discountedPrice);
    }
}
