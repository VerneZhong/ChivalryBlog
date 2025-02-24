package com.chivalry.spring.boot.examples.test;

import com.chivalry.spring.boot.examples.order.DiscountService;
import com.chivalry.spring.boot.examples.order.DiscountServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Mr.Zxb
 * @description
 * @date 2024/10/12 20:05
 */
public class DiscountServiceStudentTest {
    private final DiscountService discountService = new DiscountServiceImpl();

    @Test
    public void testStudentDiscount() {
        double price = 100.0;
        String userType = "student";
        double discountedPrice = discountService.applyDiscount(price, userType);
        assertEquals(80.0, discountedPrice);
    }
}
