package com.naveen.reconciliation_system.controller;

import com.naveen.reconciliation_system.config.JwtUtil;
import com.naveen.reconciliation_system.dto.AuthRequest;
import com.naveen.reconciliation_system.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        if(request.getUsername().equals("admin")
                && request.getPassword().equals("admin123")) {

            String token = jwtUtil.generateToken(request.getUsername());

            return new AuthResponse(token);
        }

        throw new RuntimeException("Invalid Username or Password");
    }
}