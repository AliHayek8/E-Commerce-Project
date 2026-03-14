package com.ecommerce.dto.order;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class OrderResponseDTO {

    private Long id;
    private LocalDate orderDate;
    private String customerName;
    private double totalAmount;
    private List<OrderItemResponseDTO> items;

}