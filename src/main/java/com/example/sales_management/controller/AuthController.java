package com.example.sales_management.controller;

import com.example.sales_management.entity.User;
import com.example.sales_management.security.JwtUtil;
import com.example.sales_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User saved = userService.register(user);
        return ResponseEntity.ok(Map.of("message", "Đăng ký thành công"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        User user = userService.findByUsername(username);

        if (user != null && userService.checkPassword(password, user.getPassword())) {
            String token = jwtUtil.generateToken(username, user.getRole());
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body(Map.of("message", "Sai username hoặc password"));
    }
}