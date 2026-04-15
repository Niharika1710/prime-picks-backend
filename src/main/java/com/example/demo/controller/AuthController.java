
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 🔐 SIGNUP API
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        // check if user already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "User already exists!";
        }

        userRepository.save(user);
        return "User registered successfully!";
    }
    @PostMapping("/login")
public String login(@RequestBody User user) {

    User existingUser = userRepository.findByEmail(user.getEmail());

    if (existingUser == null) {
        return "User not found!";
    }

    if (!existingUser.getPassword().equals(user.getPassword())) {
        return "Invalid password!";
    }

    return "Login successful!";
}
}