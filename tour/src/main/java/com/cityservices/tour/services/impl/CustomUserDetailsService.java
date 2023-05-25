package com.cityservices.tour.services.impl;

import com.cityservices.tour.models.User;
import com.cityservices.tour.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return buildUserForAuthentication(user);
    }
    public org.springframework.security.core.userdetails.User buildUserForAuthentication(User user) {
        // Convert user's role to a GrantedAuthority object
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());

        // Create a collection of GrantedAuthority objects
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);

        // Build and return the User object
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorities);
    }
}

