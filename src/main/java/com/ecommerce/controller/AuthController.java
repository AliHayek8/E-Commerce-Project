package com.ecommerce.controller;

import com.ecommerce.dto.auth.LoginResponseDTO;
import com.ecommerce.model.User;
import com.ecommerce.security.JwtUtil;
import com.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody User user){

        User loggedUser = userService.login(user.getEmail(), user.getPassword());

        String token = jwtUtil.generateToken(
                loggedUser.getEmail(),
                loggedUser.getRole().name()
        );

        return new LoginResponseDTO(token);
    }
}