package com.corner.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Members {
    @Id
    private Long memberId;
    private String name;
    private Long familyId;
    private String houseName;
}
