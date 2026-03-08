package com.ecommerce.strategy;

import com.ecommerce.model.Order;

public class CashPayment implements PaymentStrategy {

    @Override
    public void pay(Order order) {
        System.out.println("Paid " + order.getTotalAmount() + " in Cash for customer: " + order.getCustomer().getName());
    }
}
