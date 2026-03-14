package com.ecommerce.controller;

import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.customer.CustomerRequestDTO;
import com.ecommerce.dto.customer.CustomerResponseDTO;
import com.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")

public class CustomerController {

    @Autowired
    private CustomerService customerService;


    // GET ALL
    @GetMapping
    public ApiResponse<List<CustomerResponseDTO>> getAllCustomers(){

        List<CustomerResponseDTO> customers = customerService.getAllCustomers();

        return new ApiResponse<>(
                true,
                "Customers fetched successfully",
                customers
        );
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ApiResponse<CustomerResponseDTO> getCustomerById(@PathVariable Long id){

        CustomerResponseDTO customer = customerService.getCustomerById(id);

        return new ApiResponse<>(
                true,
                "Customer fetched successfully",
                customer
        );
    }


    // CREATE
    @PostMapping
    public ApiResponse<CustomerResponseDTO> addCustomer(
            @RequestBody CustomerRequestDTO dto){

        CustomerResponseDTO savedCustomer = customerService.addCustomer(dto);

        return new ApiResponse<>(
                true,
                "Customer created successfully",
                savedCustomer
        );
    }


    // UPDATE
    @PutMapping("/{id}")
    public ApiResponse<CustomerResponseDTO> updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerRequestDTO dto){

        CustomerResponseDTO updatedCustomer = customerService.updateCustomer(id, dto);

        return new ApiResponse<>(
                true,
                "Customer updated successfully",
                updatedCustomer
        );
    }


    // DELETE
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteCustomer(@PathVariable Long id){

        customerService.deleteCustomer(id);

        return new ApiResponse<>(
                true,
                "Customer deleted successfully",
                null
        );
    }

}