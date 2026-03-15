package com.ecommerce.controller;

import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.order.OrderRequestDTO;
import com.ecommerce.dto.order.OrderResponseDTO;
import com.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")

public class OrderController {

    @Autowired
    private OrderService orderService;


    // CREATE ORDER
    @PostMapping
    public ApiResponse<OrderResponseDTO> createOrder(@Valid @RequestBody OrderRequestDTO dto){

        OrderResponseDTO savedOrder = orderService.createOrder(dto);

        return new ApiResponse<>(
                true,
                "Order created successfully",
                savedOrder
        );
    }


    // GET ALL ORDERS
    @GetMapping
    public ApiResponse<List<OrderResponseDTO>> getAllOrders(){

        List<OrderResponseDTO> orders = orderService.getAllOrders();

        return new ApiResponse<>(
                true,
                "Orders fetched successfully",
                orders
        );
    }


    // GET ORDER BY ID
    @GetMapping("/{id}")
    public ApiResponse<OrderResponseDTO> getOrderById(@PathVariable Long id){

        OrderResponseDTO order = orderService.getOrderById(id);

        return new ApiResponse<>(
                true,
                "Order fetched successfully",
                order
        );
    }


    // DELETE ORDER
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteOrder(@PathVariable Long id){

        orderService.deleteOrder(id);

        return new ApiResponse<>(
                true,
                "Order deleted successfully",
                null
        );
    }

}