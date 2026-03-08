package com.ecommerce.controller;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;
import com.ecommerce.service.OrderService;

import java.util.List;

public class OrderController {

    private OrderService orderService;


    public OrderController() {
        this.orderService = new OrderService();
    }


    public Order createOrder(Customer customer, List<OrderItem> items) {
        Order order = orderService.createOrder(customer, items);
        System.out.println("Order created for customer: " + customer.getName() + " | Total: " + order.getTotalAmount());
        return order;
    }


    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
