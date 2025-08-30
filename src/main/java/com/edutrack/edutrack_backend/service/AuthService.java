package com.edutrack.edutrack_backend.service;


import com.edutrack.edutrack_backend.repository.CollegeRepository;
import com.edutrack.edutrack_backend.repository.CompanyRepository;
import com.edutrack.edutrack_backend.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final StudentRepository studentRepo;
    private final CollegeRepository collegeRepo;
    private final CompanyRepository companyRepo;

    public AuthService(StudentRepository studentRepo, CollegeRepository collegeRepo, CompanyRepository companyRepo) {
        this.studentRepo = studentRepo;
        this.collegeRepo = collegeRepo;
        this.companyRepo = companyRepo;
    }

    public Object login(String email, String password, String role) {
        switch (role.toUpperCase()) {
            case "STUDENT":
                return studentRepo.findByEmail(email)
                        .filter(u -> u.getPassword().equals(password))
                        .orElse(null);
            case "COLLEGE":
                return collegeRepo.findByEmail(email)
                        .filter(u -> u.getPassword().equals(password))
                        .orElse(null);
            case "COMPANY":
                return companyRepo.findByEmail(email)
                        .filter(u -> u.getPassword().equals(password))
                        .orElse(null);
            default:
                return null;
        }
    }
}
