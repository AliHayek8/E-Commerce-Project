package com.ecommerce.strategy;

import com.ecommerce.model.Order;

public class PaypalPayment implements PaymentStrategy {

    @Override
    public void pay(Order order) {
        System.out.println("Paid " + order.getTotalAmount() + " using PayPal for customer: " + order.getCustomer().getName());
    }
}
