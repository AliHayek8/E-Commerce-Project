package com.ecommerce.repository;

import com.ecommerce.model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private static OrderRepository instance;


    private List<Order> orders;


    private OrderRepository() {
        orders = new ArrayList<>();
    }


    public static OrderRepository getInstance() {
        if (instance == null) {
            instance = new OrderRepository();
        }
        return instance;
    }


    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getAllOrders() {
        return orders;
    }

}
