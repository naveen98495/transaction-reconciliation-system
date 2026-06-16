package com.naveen.reconciliation_system.service;

import com.naveen.reconciliation_system.dto.AuthRequest;
import com.naveen.reconciliation_system.dto.AuthResponse;
import com.naveen.reconciliation_system.dto.RegisterRequest;
import com.naveen.reconciliation_system.entity.Role;
import com.naveen.reconciliation_system.entity.User;
import com.naveen.reconciliation_system.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String register(RegisterRequest request) {

        if (userRepository.findByUsername(
                request.getUsername()).isPresent()) {

            return "Username already exists";
        }

        User user = new User();

        user.setUsername(request.getUsername());

        user.setPassword(request.getPassword());

        user.setRole(Role.USER);

        userRepository.save(user);

        return "User registered successfully";
    }

    public AuthResponse login(AuthRequest request) {

        User user = userRepository.findByUsername(
                request.getUsername()
        ).orElseThrow(() ->
                new RuntimeException("User not found"));

        if (!user.getPassword().equals(
                request.getPassword())) {

            throw new RuntimeException(
                    "Invalid password"
            );
        }

        String token =
                "JWT-TOKEN-" + user.getUsername();

        return new AuthResponse(token);
    }
}