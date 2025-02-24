package com.chivalry.spring.boot.examples.order;

public interface DiscountService {
    double applyDiscount(double price, String userType);
}
