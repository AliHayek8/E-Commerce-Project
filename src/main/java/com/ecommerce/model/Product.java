package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private int stockQuantity;


    public void reduceStock(int quantity) {
        this.stockQuantity -= quantity;
    }


    public void increaseStock(int quantity) {
        this.stockQuantity += quantity;
    }


}