package com.corner.chronicleregister.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String houseName;
    private String area;
    private String place;
    private String district;
    private String state;
    private int postCode;

//    @OneToMany
//    @JoinColumn(name = "members")
//    private Members members;
}
