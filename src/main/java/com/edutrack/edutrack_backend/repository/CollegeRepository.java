package com.edutrack.edutrack_backend.repository;

import com.edutrack.edutrack_backend.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollegeRepository extends JpaRepository<College, Long> {
    Optional<College> findByEmail(String email);
}
