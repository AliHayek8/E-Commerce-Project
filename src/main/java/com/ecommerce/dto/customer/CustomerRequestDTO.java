package com.ecommerce.dto.customer;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class CustomerRequestDTO {

    @NotBlank(message = "Customer name cannot be empty")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    private String email;

}