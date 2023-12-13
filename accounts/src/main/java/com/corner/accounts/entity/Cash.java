package com.corner.accounts.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Cash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private Date date;
    private LocalDateTime enteredDate;
    private String enteredBy;
    private boolean isVerified;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="members")
    private Members members;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="accountType")
    private AccountType accountType;
}
