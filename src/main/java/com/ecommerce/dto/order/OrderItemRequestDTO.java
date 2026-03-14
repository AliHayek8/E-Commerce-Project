package com.ecommerce.dto.order;

import lombok.Data;

@Data
public class OrderItemRequestDTO {

    private Long productId;
    private int quantity;
}