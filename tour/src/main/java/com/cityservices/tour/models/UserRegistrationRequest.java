package com.cityservices.tour.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {
    private String username;
    private String password;
    private String email;
    // Other registration fields

    // Constructors, getters, and setters
}

