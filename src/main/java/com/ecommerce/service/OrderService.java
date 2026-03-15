package com.ecommerce.service;

import com.ecommerce.dto.order.*;
import com.ecommerce.exception.OrderNotFoundException;
import com.ecommerce.model.*;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;



    // CREATE ORDER


    public OrderResponseDTO createOrder(OrderRequestDTO dto){

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new OrderNotFoundException(dto.getCustomerId()));

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDate.now());

        List<OrderItem> orderItems = new ArrayList<>();

        for(OrderItemRequestDTO itemDTO : dto.getItems()){

            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new OrderNotFoundException(itemDTO.getProductId()));

            OrderItem item = new OrderItem();

            item.setProduct(product);
            item.setQuantity(itemDTO.getQuantity());
            item.setPrice(product.getPrice());
            item.setOrder(order);

            orderItems.add(item);
        }

        order.setItems(orderItems);

        order.calculateTotal();

        Order savedOrder = orderRepository.save(order);

        return mapToDTO(savedOrder);
    }



    // GET ALL ORDERS


    public List<OrderResponseDTO> getAllOrders(){

        List<Order> orders = orderRepository.findAll();

        List<OrderResponseDTO> result = new ArrayList<>();

        for(Order order : orders){
            result.add(mapToDTO(order));
        }

        return result;
    }



    // GET ORDER BY ID


    public OrderResponseDTO getOrderById(Long id){

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        return mapToDTO(order);
    }



    // DELETE ORDER


    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }



    // MAPPING METHODS


    private OrderResponseDTO mapToDTO(Order order){

        OrderResponseDTO dto = new OrderResponseDTO();

        dto.setId(order.getId());
        dto.setOrderDate(order.getOrderDate());
        dto.setCustomerName(order.getCustomer().getName());
        dto.setTotalAmount(order.getTotalAmount());

        List<OrderItemResponseDTO> itemDTOs = new ArrayList<>();

        for(OrderItem item : order.getItems()){

            OrderItemResponseDTO itemDTO = new OrderItemResponseDTO();

            itemDTO.setProductId(item.getProduct().getId());
            itemDTO.setProductName(item.getProduct().getName());
            itemDTO.setQuantity(item.getQuantity());
            itemDTO.setPrice(item.getPrice());
            itemDTO.setSubtotal(item.calculateSubtotal());

            itemDTOs.add(itemDTO);
        }

        dto.setItems(itemDTOs);

        return dto;
    }

}