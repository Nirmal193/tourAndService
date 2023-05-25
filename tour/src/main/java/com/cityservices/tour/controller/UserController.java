package com.cityservices.tour.controller;

import com.cityservices.tour.models.Role;
import com.cityservices.tour.models.User;
import com.cityservices.tour.models.UserRegistrationRequest;
import com.cityservices.tour.repository.RoleRepository;
import com.cityservices.tour.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest request) {
        // Validate input, perform necessary checks

        Role role = roleRepository.findByName("editor"); // Get the role from the repository

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }
}

