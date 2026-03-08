package com.ecommerce.model;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private Long id;
    private LocalDate orderDate;
    private Customer customer;
    private List<OrderItem> items;
    private double totalAmount;

    public Order(Long id, LocalDate orderDate, Customer customer, List<OrderItem> items) {
        this.id = id;
        this.orderDate = orderDate;
        this.customer = customer;
        this.items = items;
    }


    public Long getId() {
        return id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }



    public double calculateTotal() {

        double total = 0;

        for (OrderItem item : items) {
            total += item.calculateSubtotal();
        }

        this.totalAmount = total;

        return total;
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

}
