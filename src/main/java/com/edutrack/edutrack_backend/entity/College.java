package com.edutrack.edutrack_backend.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class College extends BaseUser {
    private String universityName;
    private String location;
}