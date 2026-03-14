package com.ecommerce.dto.product;

import lombok.Data;

@Data
public class ProductRequestDTO {

    private String name;
    private double price;
    private int stockQuantity;

}