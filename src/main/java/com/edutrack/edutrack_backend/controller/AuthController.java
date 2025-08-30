package com.edutrack.edutrack_backend.controller;

import com.edutrack.edutrack_backend.entity.College;
import com.edutrack.edutrack_backend.entity.Company;
import com.edutrack.edutrack_backend.entity.Student;
import com.edutrack.edutrack_backend.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth/register")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ===== Registration Endpoints =====

    @PostMapping("/student")
    public Object registerStudent(@RequestBody Student student) {
        boolean success = authService.registerStudent(student);
        if (!success) {
            return Map.of("success", false, "message", "Student registration failed");
        }
        return Map.of("success", true, "user", student);
    }

    @PostMapping("/college")
    public Object registerCollege(@RequestBody College college) {
        boolean success = authService.registerCollege(college);
        if (!success) {
            return Map.of("success", false, "message", "College registration failed");
        }
        return Map.of("success", true, "user", college);
    }

    @PostMapping("/company")
    public Object registerCompany(@RequestBody Company company) {
        boolean success = authService.registerCompany(company);
        if (!success) {
            return Map.of("success", false, "message", "Company registration failed");
        }
        return Map.of("success", true, "user", company);
    }

    // ===== Login Endpoint =====
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