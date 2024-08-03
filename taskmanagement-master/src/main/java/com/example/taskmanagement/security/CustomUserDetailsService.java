package com.example.taskmanagement.security;

import com.example.taskmanagement.models.User;
import com.example.taskmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElse(null);

        if(user == null)
        {
            throw new UsernameNotFoundException("Could not found user !!");

        }
        CustomUserDetails customUserDetails = new CustomUserDetails(user);

        return customUserDetails;
    }
}