package com.ecommerce.dto.product;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class ProductRequestDTO {

    @NotBlank(message = "Product name cannot be empty")
    private String name;

    @Positive(message = "Price must be positive")
    private double price;

    @Min(value = 0, message = "Stock cannot be negative")
    private int stockQuantity;

}