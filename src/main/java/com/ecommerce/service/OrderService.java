package com.ecommerce.service;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;
import com.ecommerce.repository.OrderRepository;
import java.time.LocalDate;
import java.util.List;


public class OrderService {

    private OrderRepository orderRepository;


    public OrderService() {
        this.orderRepository = OrderRepository.getInstance();
    }


    public Order createOrder(Customer customer, List<OrderItem> items) {
        Order order = new Order(
                null,                  // id
                LocalDate.now(),
                customer,
                items
        );
        order.calculateTotal();
        orderRepository.addOrder(order);
        return order;
    }


    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

}
