package com.ecommerce.config;

import com.ecommerce.strategy.PaymentStrategy;
import com.ecommerce.strategy.CreditCardPayment;
import com.ecommerce.strategy.PaypalPayment;
import com.ecommerce.strategy.CashPayment;


public class AppConfig {

    public static PaymentStrategy getPaymentStrategy(String type) {
        switch (type.toLowerCase()) {
            case "creditcard":
                return new CreditCardPayment();
            case "paypal":
                return new PaypalPayment();
            case "cash":
                return new CashPayment();
            default:
                throw new IllegalArgumentException("Invalid payment type: " + type);
        }
    }
}
