package com.ecommerce.dto.product;

import lombok.Data;

@Data
public class ProductResponseDTO {

    private Long id;
    private String name;
    private double price;
    private int stockQuantity;

}