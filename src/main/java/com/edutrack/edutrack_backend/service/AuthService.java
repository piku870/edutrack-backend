package com.edutrack.edutrack_backend.service;


import com.edutrack.edutrack_backend.entity.College;
import com.edutrack.edutrack_backend.entity.Company;
import com.edutrack.edutrack_backend.entity.Student;
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

    // ===== Login =====
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

    // ===== Registration =====
    public boolean registerStudent(Student student) {
        // Optional: check if email already exists
        if (studentRepo.findByEmail(student.getEmail()).isPresent()) {
            return false;
        }
        studentRepo.save(student);
        return true;
    }

    public boolean registerCollege(College college) {
        if (collegeRepo.findByEmail(college.getEmail()).isPresent()) {
            return false;
        }
        collegeRepo.save(college);
        return true;
    }

    public boolean registerCompany(Company company) {
        if (companyRepo.findByEmail(company.getEmail()).isPresent()) {
            return false;
        }
        companyRepo.save(company);
        return true;
    }
}
