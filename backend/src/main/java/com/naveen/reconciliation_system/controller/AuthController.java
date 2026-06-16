package com.naveen.reconciliation_system.controller;

import com.naveen.reconciliation_system.config.JwtUtil;
import com.naveen.reconciliation_system.dto.AuthRequest;
import com.naveen.reconciliation_system.dto.AuthResponse;
import com.naveen.reconciliation_system.dto.RegisterRequest;
import com.naveen.reconciliation_system.entity.Role;
import com.naveen.reconciliation_system.entity.User;
import com.naveen.reconciliation_system.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // REGISTER API
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        User user = new User();

        user.setUsername(request.getUsername());

        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setRole(request.getRole());

        userRepository.save(user);

        return ResponseEntity.ok("User Registered Successfully");
    }

    // LOGIN API
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElse(null);

        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        boolean passwordMatch = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!passwordMatch) {
            return ResponseEntity.badRequest().body("Invalid Password");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return ResponseEntity.ok(
                new AuthResponse(token)
        );
    }
}