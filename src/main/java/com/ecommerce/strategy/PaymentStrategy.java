package com.ecommerce.strategy;

import com.ecommerce.model.Order;

public interface PaymentStrategy {

    void pay(Order order);
}
