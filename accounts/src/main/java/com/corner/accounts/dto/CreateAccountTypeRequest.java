package com.corner.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateAccountTypeRequest {
    private String type;
    private String description;
}