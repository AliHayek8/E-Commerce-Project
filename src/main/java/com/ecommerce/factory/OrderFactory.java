package com.ecommerce.factory;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;

import java.time.LocalDate;
import java.util.List;

public class OrderFactory {

    public static Order createOrder(Customer customer, List<OrderItem> items) {
        Order order = new Order(
                null, // id
                LocalDate.now(),
                customer,
                items
        );
        order.calculateTotal();
        return order;
    }
}
