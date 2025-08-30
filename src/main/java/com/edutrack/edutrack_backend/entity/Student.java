package com.edutrack.edutrack_backend.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends BaseUser {
    private String course;
    private String year;
}