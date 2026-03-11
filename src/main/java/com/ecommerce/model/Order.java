package com.ecommerce.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "orders")

@Data
@NoArgsConstructor


public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;

    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;


    public Order(Long id, LocalDate orderDate, Customer customer, List<OrderItem> items) {
        this.id = id;
        this.orderDate = orderDate;
        this.customer = customer;
        this.items = items;
    }

    public double calculateTotal(){
        double total = 0;
        for(OrderItem item : items){
            total += item.calculateSubtotal();
        }
        this.totalAmount = total;
        return total;
    }


}
