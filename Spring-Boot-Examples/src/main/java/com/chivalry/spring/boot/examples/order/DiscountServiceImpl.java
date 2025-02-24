package com.chivalry.spring.boot.examples.order;

import org.springframework.stereotype.Service;

/**
 * @author Mr.Zxb
 * @description
 * @date 2024/10/12 20:04
 */
@Service
public class DiscountServiceImpl implements DiscountService {
    @Override
    public double applyDiscount(double price, String userType) {
        if (userType == null || userType.isEmpty()) {
            return price; // No discount if user type is not provided
        }

        switch (userType.toLowerCase()) {
            case "student":
                return price * 0.8; // 20% discount for students
            case "senior":
                return price * 0.7; // 30% discount for seniors
            case "member":
                return price * 0.9; // 10% discount for members
            case "vip":
                return price * 0.5; // 50% discount for VIPs
            default:
                return price; // No discount for others
        }
    }
}
