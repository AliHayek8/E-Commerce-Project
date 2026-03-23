package com.ecommerce.dto.auth;

import lombok.*;

@Data
@AllArgsConstructor
public class RegisterResponseDTO {

    private Long id;
    private String email;
    private String role;

}