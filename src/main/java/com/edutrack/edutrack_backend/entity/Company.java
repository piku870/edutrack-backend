package com.edutrack.edutrack_backend.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company extends BaseUser {
    private String industry;
    private String website;
}