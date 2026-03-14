package com.ecommerce.dto.order;

import lombok.Data;

@Data
public class OrderItemResponseDTO {

    private Long productId;
    private String productName;
    private int quantity;
    private double price;
    private double subtotal;

}