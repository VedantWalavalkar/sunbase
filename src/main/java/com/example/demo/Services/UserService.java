package com.example.demo.Services;

import com.example.demo.DTO.RequestUser;
import com.example.demo.Modals.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder passwordEncoder;
    public void addUser(RequestUser requestUser) {
        User user = new User();
        user.setUsername(requestUser.getUsername());
        user.setPassword(passwordEncoder.encode(requestUser.getPassword()));
        user.setRoles(requestUser.getRoles());


    }
}
