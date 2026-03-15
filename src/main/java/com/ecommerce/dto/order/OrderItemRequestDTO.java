package com.ecommerce.dto.order;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class OrderItemRequestDTO {

    @NotNull(message = "Product id is required")
    private Long productId;

    @Positive(message = "Quantity must be positive")
    private int quantity;

}