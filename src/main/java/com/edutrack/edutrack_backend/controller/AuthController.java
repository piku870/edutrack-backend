package com.edutrack.edutrack_backend.controller;

import com.edutrack.edutrack_backend.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Object login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");
        String role = body.get("role"); // STUDENT / COLLEGE / COMPANY

        Object user = authService.login(email, password, role);
        if (user == null) {
            return Map.of("success", false, "message", "Invalid credentials");
        }
        return Map.of("success", true, "user", user);
    }
}