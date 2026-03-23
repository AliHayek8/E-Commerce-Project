package com.ecommerce.controller;

import com.ecommerce.dto.ApiResponse;
import com.ecommerce.dto.auth.LoginResponseDTO;
import com.ecommerce.dto.auth.RegisterResponseDTO;
import com.ecommerce.model.User;
import com.ecommerce.security.JwtUtil;
import com.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterResponseDTO>> register(@RequestBody User user) {
        User savedUser = userService.register(user);

        RegisterResponseDTO data = new RegisterResponseDTO(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getRole().name()
        );

        ApiResponse<RegisterResponseDTO> response = new ApiResponse<>(
                true,
                "Registered successfully",
                data
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDTO>> login(@RequestBody User user) {
        User loggedUser = userService.login(user.getEmail(), user.getPassword());

        String token = jwtUtil.generateToken(
                loggedUser.getEmail(),
                loggedUser.getRole().name()
        );

        ApiResponse<LoginResponseDTO> response = new ApiResponse<>(
                true,
                "Login successful",
                new LoginResponseDTO(token)
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}