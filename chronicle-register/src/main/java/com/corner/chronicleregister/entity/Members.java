package com.corner.chronicleregister.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int phone;
    private String email;
//    private Date dateOfBirth;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "family")
    private Family family;
}
