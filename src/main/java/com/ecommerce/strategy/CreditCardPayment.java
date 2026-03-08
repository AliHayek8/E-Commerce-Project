package com.ecommerce.strategy;

import com.ecommerce.model.Order;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(Order order) {
        System.out.println("Paid " + order.getTotalAmount() + " using Credit Card for customer: " + order.getCustomer().getName());
    }
}
