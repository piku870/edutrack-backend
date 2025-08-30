package com.edutrack.edutrack_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "✅ EduTrack Backend is running successfully on Railway 🚀";
    }
}
