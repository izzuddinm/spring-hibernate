package com.izzuddinm.spring_hibernate.model.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "career")
@Getter
@Setter
public class Career {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String location;
    private String department;
    private String type;

    @Column(name = "posted_date")
    private LocalDateTime postedDate = LocalDateTime.now();

    @Column(name = "is_active")
    private boolean isActive = true;
}
